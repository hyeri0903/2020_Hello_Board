# Board (2020.02)

**Project : Develop Board using Spring Framework**
프로젝트 실행 환경 ,개발 Tool
- JAVA : jdk 1.8
- Spring Framework : 4.3.3v
- STS-3.9.11(Spring Tool Suite)
- Eclipse
- Database : Oracle 11g
- Server : Tomcat 8.5v


**프로젝트 수행 내용**
- web.xml -> Tomcat 서버
- Spring MVC -> servlet-context.xml
- Spirng Core -> root-context.xml
- MyBatis -> root-context.xml
- DB

**Spring 주요 특징**
- POJO 기반의 구성 (Plain Old Java Object), 일반적인 Java 코드를 이용해서 객체를 구성하는 방식을 스프링에서도 사용 가능
- 의존성 주입(DI)을 통한 객체 간의 관계 구성
- AOP(Aspect - Oriented - Programming) 지원
- 편리한 MVC 구조
- WAS의 종속적이지 않은 개발 환경
-
**Spring Framework 버전 별 차이**
- 2.5 : 어노테이션(Annotation)을 활용하는 설정을 도입하면서 편리한 설정과 개발이 가능하도록 지원
- 3.0 : 별도의 설정 없이도 JAVA 클래스만으로 설정 파일을 대신할 수 있게 지원
- 4.0 : 모바일 환경과 웹 환경에서 많이 사용되는 REST 방식의 컨트롤러 지원
- 5.0 : Reactor를 이용한 Reactive 스타일의 개발 환경 지원

**아파치 웹 서버와 Tomcat**
- 아파치 : 웹 서버 오픈소스 SW, 웹 서버 역할로 HTTP 프로토콜을 이용하여 서버에 request를 하면 그에맞는 reponse를 반환하여 브라우저에 출력.
- Tomcat : 아파치 SW 재단의 어플리케이션 서버, 자바 서블릿을 실행시키고 JSP 코드가 포함되어 있는 웹페이지를 만들어줌. 즉, 톰캣은 웹 서버에서 넘어온 동적인 페이지를 읽어들여 프로그램을 실행하고 그 결과를 다시 html로 재구성하여 아파치에게 되돌려준다. 톰캣을 실행시키기 위해서는 JRE 1.1에 부합되는 자바 런타임 환경이 필요하다.

**아파치 메이븐 (Maven)**
Apache Maven은 은 Apache 재단에서 제작한 프로젝트로 Java 기반의 프로젝트 세팅에 있어서 매우 손쉽게 프로젝트 관리를 지원해주는 오픈소스 프로젝트이다.
프로젝트 개체 모델 (POM, Project Object Model)의 개념을 기반으로 Maven은 프로젝트 빌드, 라이프 사이클 관리를한다.
pom.xml 기반으로 작동.
pom.xml 파일 안의 dependency 수정

**Mybatis**
- 객체 지향 언어인 자바의 관계형 데이터베이스 프로그래밍을 좀 더 쉽게 할 수 있게 도와 주는 개발 프레임 워크로서 JDBC를 통해 데이터베이스에 엑세스하는 작업을 캡슐화하고 일반 SQL 쿼리, 저장 프로 시저 및 고급 매핑을 지원하며 모든 JDBC 코드 및 매개 변수의 중복작업을 제거.
- Mybatis에서는 프로그램에 있는 SQL쿼리들을 한 구성파일에 구성하여 프로그램 코드와 SQL을 분리할 수 있는 장점


참조 : 코드로 배우는 스프링 웹 프로젝트
