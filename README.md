# Board
Develop Board using Spring Framework

- JAVA : jdk 1.8
- Spring Framework : STS-3.9.11(Spring Tool Suite)
- Eclipse
- Database : Oracle 11g
- Server : Tomcat 8.5v


프로젝트 수행 내용
- web.xml -> Tomcat 서버
- Spring MVC -> servlet-context.xml
- Spirng Core -> root-context.xml
- MyBatis -> root-context.xml
- DB


Spring 주요 특징
- POJO 기반의 구성 (Plain Old Java Object), 일반적인 Java 코드를 이용해서 객체를 구성하는 방식을 스프링에서도 사용 가능
- 의존성 주입(DI)을 통한 객체 간의 관계 구성
- AOP(Aspect - Oriented - Programming) 지원
- 편리한 MVC 구조
- WAS의 종속적이지 않은 개발 환경
-
Spring Framework 버전 별 차이
- 2.5 : 어노테이션(Annotation)을 활용하는 설정을 도입하면서 편리한 설정과 개발이 가능하도록 지원
- 3.0 : 별도의 설정 없이도 JAVA 클래스만으로 설정 파일을 대신할 수 있게 지원
- 4.0 : 모바일 환경과 웹 환경에서 많이 사용되는 REST 방식의 컨트롤러 지원
- 5.0 : Reactor를 이용한 Reactive 스타일의 개발 환경 지원

아파치 웹 서버 Tomcat
- 아파치 : 웹 서버 오픈소스 SW, 웹 서버 역할로 HTTP 프로토콜을 이용하여 서버에 request를 하면 그에맞는 reponse를 반환하여 브라우저에 출력.
- Tomcat : 아파치 SW 재단의 어플리케이션 서버, 자바 서블릿을 실행시키고 JSP 코드가 포함되어 있는 웹페이지를 만들어줌. 즉, 톰캣은 웹 서버에서 넘어온 동적인 페이지를 읽어들여 프로그램을 실행하고 그 결과를 다시 html로 재구성하여 아파치에게 되돌려준다. 톰캣을 실행시키기 위해서는 JRE 1.1에 부합되는 자바 런타임 환경이 필요하다.

아파치 메이븐
Apache Maven은 소프트웨어 프로젝트 관리 및 이해 도구이다.
프로젝트 개체 모델 (POM)의 개념을 기반으로 Maven은 중앙 정보에서 프로젝트의 빌드,보고 및 문서를 관리 할 수 있다.
pom.xml 기반으로 작동.
pom.xml 파일 안의 dependency 수정


참조 : 코드로 배우는 스프링 웹 프로젝트
