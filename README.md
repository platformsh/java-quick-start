# java-quick-start
Java Quick Start for Platform.sh. Maintained by the Platform.sh team.

## Blog code Content

| Blog        | Content         |
| ------------- |:-------------:|
|Get to Know JSF: An Easy and Straightforward a Jakarta Framework](https://dzone.com/articles/get-to-know-jsf-an-easy-and-straightforward-a-jaka)| [Code]() |
|[What’s new with Jakarta NoSQL? (Part II)](https://platform.sh/blog/2020/what-is-new-with-jakarta-nosql-part-ii/)| [Code](https://github.com/platformsh/java-quick-start/tree/master/jakarta/mongodb-nosql-m1) |
|[What's new with Jakarta NoSQL? (Part I)](https://platform.sh/blog/2019/what-is-new-with-jakarta-nosql/)| [Code](https://github.com/platformsh/java-quick-start/tree/master/jakarta/mongodb-nosql-m1) |
|[Spring Data Redis in the cloud](https://platform.sh/blog/2019/spring-data-redis-in-the-cloud/)| [Code](https://github.com/platformsh/java-quick-start/tree/master/spring/spring-boot-maven-redis) |
|[Simplify your script build with Gradle](https://platform.sh/blog/2019/simplify-your-script-build-with-gradle/)| [code](https://github.com/platformsh-templates/spring-boot-gradle-mysql) |
|[Microservices in the cloud, part two](https://platform.sh/blog/2019/microservices-in-the-cloud-part-two/)| [Code](https://github.com/EventosJEspanol/latin-america-micro-profile) |
|[Microservices in the cloud, part one](https://platform.sh/blog/2019/microservices-in-the-cloud-part-one/)| [Code](https://github.com/EventosJEspanol/latin-america-micro-profile) |
|[Jakarta EE: Generation IV - a new hope](https://platform.sh/blog/2019/jakarta-ee-generation-iv-a-new-hope/)| [Code](https://github.com/platformsh/java-quick-start/tree/master/jakarta/tomee-mongodb) |
|[Eclipse MicroProfiles: gain agility, release faster](https://platform.sh/blog/2019/eclipse-microprofiles-gain-agility-release-faster/)| [Code](https://github.com/platformsh/java-quick-start/tree/master/eclipse-microprofile/thorntail-jpa) |
|[Elasticsearch vs. Solr: have both with Spring Data and Platform.sh](https://platform.sh/blog/2019/elasticsearch-vs-solr-have-both-with-spring-data-and-platform.sh/)| [Elasticsearch](https://github.com/platformsh/java-quick-start/tree/master/spring/spring-mvc-maven-elasticsearch) and [Solr](https://github.com/platformsh/java-quick-start/tree/master/spring/spring-mvc-maven-solr) |
|[Spring MVC and MongoDB: a match made in Platform.sh heaven](https://platform.sh/blog/2019/spring-mvc-and-mongodb-a-match-made-in-platform.sh-heaven/)| [Code](https://github.com/platformsh/java-quick-start/tree/master/spring/spring-mvc-maven-mongodb) |
|[Java: Hello, World! at Platform.sh](https://platform.sh/blog/2019/java-hello-world-at-platform.sh/)| [Code](https://github.com/platformsh/java-quick-start/tree/master/spring/spring-boot-maven-mysql) |

## How to use:

1. Select the category

* [Spring](spring/)
* [Eclipse MicroProfile](eclipse-microprofile)
* [Jakarta EE](jakarta)


2. Choose a project on a category:
3. Create a new [free trial account](https://docs.platform.sh/gettingstarted/first-project.html#your-first-project).
4. Sign up with a new user and password, or login using a current  GitHub, Bitbucket, or Google account. If you use a third-party login, you’ll be able to set a password for your Platform.sh account later.
5. Select the region of the world where your site should live.
6. Select the blank template.

After this wizard, Platform.sh will provision the whole infrastructure to you, and Platform.sh will offer a Git remote repository. Before access, remember to set the SSH keys. The Platform.sh Git-driven infrastructure means it will automatically manage everything your application needs to push it to the master remote repository. You only need to write your code—including a few YAML files that specify your desired infrastructure—then commit it to Git and push.

7. On the selected project execute these command:

```bash
git init
git remote add platform <platform.sh@gitrepository>
git commit -m "Initial project"
git push -u platform master
```
