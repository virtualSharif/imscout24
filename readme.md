#Documentation
	Project name : HTML web page analyzer
	Days took to build : Approximately 2days.
------------------------------------------------------------------------------------------------------------------------
##Steps to run the project:
	Please refer run-readme.md file.
------------------------------------------------------------------------------------------------------------------------
##Project Modules :
	This project consists of two major parts :
	a. Backend - RESTful apis build in Java Spring framework.
	b. Front-end - Single Page Application using Angular JS 1.x.
------------------------------------------------------------------------------------------------------------------------

##Project architectural points:
	Points regarding the development phase:

#####i. Modularise :
	For the time being I have modularise the project on package level.
	Later we can also modularise in maven modules.

------------------------------------------------------------------------------------------------------------------------
#####ii. DTO :
	It stands for Data Transfer Object.
	In this project DTO are used to send as response object from rest controller.

------------------------------------------------------------------------------------------------------------------------
#####iii. RESTful API design :
	Backend consists following restful apis i.e.

	a. /api/v1/urls/analysis - used for analysis of html page
	b. /api/v1/urls/statuses - used for external link(any) validation status.

------------------------------------------------------------------------------------------------------------------------
#####iv. Exception Handler via Aspect :
	Added aspect for exception handling at rest layer and send appropriate http status and error messages.

------------------------------------------------------------------------------------------------------------------------
#####v. Plugins used :
	Lombok : https://projectlombok.org/

------------------------------------------------------------------------------------------------------------------------
#####vi. Unit tests:
	Unit test written using spring boot test context and only exception thrown use cases.

------------------------------------------------------------------------------------------------------------------------
#####vii. Fetching HTML Version :
	Logic of getting html version is derived from http://w3c.github.io/html/syntax.html#the-doctype
	Where I am sending “HTML 5" if there is no public id in the doctype else entire public id of doctype.

------------------------------------------------------------------------------------------------------------------------
#####viii. Front-end :
	Single page application : Used Angular Js 1.x version.
	For the time being everything is displayed on one page i.e. analyser page.

------------------------------------------------------------------------------------------------------------------------
#####ix. Testing and documentation for RESTful apis:
	Swagger : http://swagger.io/
	I’ve added swagger framework for testing the apis.

------------------------------------------------------------------------------------------------------------------------
#####x. Comments :
	Entire code styling is influenced by Clean Code principle - Robert Martin
	Which says
	'Truth can only be found in one place: the code’.
	So you may not found any comments anywhere in the project.
	Keeping in mind that git can be used to manage version of file and method name should be kept as self explanatory.

	However, if you need comments on each file. I can do that too.

------------------------------------------------------------------------------------------------------------------------
#####xi. Design principles used in Project :
	a. SOLID (single responsibility, open-closed, Liskov subsitution, interface segragation, dependency inversion) principle,
	b. Composition over inheritance,
	c. DRY(Don’t repeat yourself),
	d. Test only exceptions,
	e. KISS(Keep it simple, stupid)
	f. and some experience principle ;)

------------------------------------------------------------------------------------------------------------------------
#####xii. Area of improvements :
	a. Test cases:
	I have written only exception thrown test case we can also write the positive test cases in future.

	b. Angular JS :
	There are lot of stuffs which we can add like divide panels into multiple pages,
	validate external links in groups (select all functionality)
	and spinner component can be added.

	c.REST uri :
	URI can reform and input url can be kept in path variable like : /api/v1/urls/{url}/statuses or /api/v1/urls/{url}/analysis

	Note : here input url is passed by request param which can be passed by path variable too.
	Keeping in mind if we pass url as path variable then it needs extra care (that url need to send encoded ).
	Hence, so removing extra overheads for the time being I have chosen url as request param.

	d. Optional task :
	As of now, /api/v1/urls/statuses?url={url} is used to validate external links -> where only one url can be validated
	Perhaps we can also do it accept list of urls and validate in backend in parallel processing or in multiple threads .