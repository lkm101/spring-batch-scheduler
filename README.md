# Spring Batch + Scheduler
## Description
> Spring Batch가 **5버전**으로 업그레이드 되면서 달라진 점에 대한 테스트 코딩
## Version
> **JAVA: 17**
> 
> Spring Batch: 5.0
## 요구사항
> [스프링 공식 홈페이지](https://docs.spring.io/spring-batch/docs/5.0.4/reference/html/whatsnew.html)
> 
> **JAVA 버전 17**
> 
> **Spring Framework 6**
## 유의할 점
> [Batch Git Hub](https://github.com/spring-projects/spring-batch/wiki/Spring-Batch-5.0-Migration-Guide#jobbuilderfactory-and-stepbuilderfactory-bean-exposureconfiguration)
> 
> Spring Batch가 5.0으로 업데이트 되면서 JobBuilderFactory 대신 **JobBuilder**를 사용할 것을 권고

## !! 에러 시 조치 사항 !!
> org.springframework.jdbc.BadSqlGrammarException: PreparedStatementCallback; bad SQL grammar [SELECT JOB_INSTANCE_ID, JOB_NAME
FROM BATCH_JOB_INSTANCE
WHERE JOB_NAME = ?
and JOB_KEY = ?]
> > 위와 같은 에러 메시지가 발생하면 **application.properties**의 **spring.batch.initialize-schema=always** 설정이 제대로 적용되지 않아서 DB에 스케줄러를 관리하는 테이블이 생성되지 않은 것이다.
> >
> > **Project and External Dependencies** -> **spring-batch-core-5.x.x.jar** -> **org.springframework.batch.core** 아래에 있는 연결한 DB에 맞는 Schema 파일에 DDL로 테이블을 생성해 주면 된다.
