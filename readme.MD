# AWS 람다 학습 


## helloLambda 프로젝트
### 특징
- 어떤 라이브러리도 없는 태초 마을 코드라 보면 됨
- 핸들러에 아래와 같이 명시해야 함
```text
 패키지.클래스명::퍼블릭메소드
```

- protected, private 은 AWS Lambda 가 무시함



## log
 
- aws 가 제공하는 aws-lambda-java-log4j2, 아파치가 제공하는 log4j2 크게 2가지 방식을 활용할 수 있는 것으로 보임
- aws 제공하는 log4j2 는 context 변수를 활용해서 지역변수로 활용해야 함 / 전역 static 변수로 한번만 생성해서 활용하는 방식은 아직 못 찾음
- apache 가 제공하는 log4j2 를 활용하면 전역변수 활용해서 로깅 가능한 것으로 보임 / 단 jar 방식으로 배포시 문제가 있었음
- log4j2 활용하려면 buildZip 방식으로 zip 파일 만들어서 배포하는게 좋아보임, 단순 jar 빌드하면 런타임때 클래스를 못찾는걸로 보임
- log4j2 전에 보안이슈로 버전 1.5.0 이상의 것 사용권장함
- aws documentation deploy 에 적혀있는 build.gradle 을 참고했음

- apache log4j2 는 debug는 콘솔에 안찍힘

- deploy 참고링크 :[https://docs.aws.amazon.com/lambda/latest/dg/java-package.html](https://docs.aws.amazon.com/lambda/latest/dg/java-package.html)
- logging 참고링크 : [https://docs.aws.amazon.com/lambda/latest/dg/java-logging.html](https://docs.aws.amazon.com/lambda/latest/dg/java-logging.html)