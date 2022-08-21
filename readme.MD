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


## spring-cloud-function

- 어떻게 쓰는지도 중요하지만 왜 쓰는지, 왜 만들었는지를 생각해보고 접근하는게 좋다 싶음

- 공식문서 보면 주저리주저리 쓰여있는데 핵심은 서버리스 환경에서 스프링 기능을 쓸 수 있다 정도가 핵심으로 보인다.
  - 스프링의 기능이라 하면 DI 나 싱글톤(default) 같은 거겠지? 혹은 스프링 AOP 같은? 많겠지 / 더 큰 건 서버리스 환경에서조차 객체지향 프로그래밍을 더 잘 하게 해준다?

```text
This question is more when to use Spring Cloud Function. 
Basically, Spring Cloud Function library allows to the creation of functional applications that can be deployed easily on AWS Lambda. 
These functions follow the Java 8 pattern of Supplier, Consumer, and Function.
spring-cloud-starter-function-web library provides native interaction for handling requests, streams.
```

- 아니, 근데 이건 서버리스 아닌 환경에서도 가능하지 않나???..... 일단 계속 ㄱㄱ


### Features of Spring Cloud Function
출처 : [https://betterjavacode.com/programming/example-spring-cloud-function-aws-lambda](https://betterjavacode.com/programming/example-spring-cloud-function-aws-lambda)
```text
The major advantage of Spring Cloud Function is it provides all the features of Spring Boot like autoconfiguration, dependency injection. 
But there are more features:
```

- Transparent type conversions of input and output
- POJO Functions **<- 비즈니스 로직에 집중할 수 있도록 하는거 마음에 든다**
- REST Support to expose functions as HTTP endpoints **<- 호출하기 편하니까 좋긴한데... 이게 맞나??**
- Streaming data to/from functions via Spring Cloud Stream framework **<-스트리밍은 아직 해본 적이 없어서 그러려니 해야겠다**
- Deploying functions as isolated jar files
- Adapter for AWS Lambda, Google Cloud Platform, Microsoft Azure **<- 이건 좀 마음에 든다**

아니 근데 막상 예제들 보니 그래들에 주입하는 것들 xxx-aws 이런식이네

백문여불여일견 직접 해봅시다

