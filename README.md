prototype-flyway-EclipseLink-H2-GlassFish
=========================================

├ 📂 src/  
│ ├ 📂 main/  
│ │ ├ 📂 java/io/github/sealor/prototype/flyway/eclipselink/h2/glassfish/  
│ │ │ ├ 📂 model/  
│ │ │ │ └ 📜 [Book.java](src/main/java/io/github/sealor/prototype/flyway/eclipselink/h2/glassfish/model/Book.java)  
│ │ │ ├ 📜 [BookService.java](src/main/java/io/github/sealor/prototype/flyway/eclipselink/h2/glassfish/BookService.java)  
│ │ │ ├ 📜 [BookServlet.java](src/main/java/io/github/sealor/prototype/flyway/eclipselink/h2/glassfish/BookServlet.java)  
│ │ │ └ 📜 [DatabaseMigrator.java](src/main/java/io/github/sealor/prototype/flyway/eclipselink/h2/glassfish/DatabaseMigrator.java)  
│ │ └ 📂 resources/  
│ │ ░ ├ 📂 db/migration/  
│ │ ░ │ ├ 📜 [V0001__create_table_book.sql](src/main/resources/db/migration/V0001__create_table_book.sql)  
│ │ ░ │ └ 📜 [V0002__add_title_to_table_book.sql](src/main/resources/db/migration/V0002__add_title_to_table_book.sql)  
│ │ ░ ├ 📂 META-INF/  
│ │ ░ │ └ 📜 [persistence.xml](src/main/resources/META-INF/persistence.xml)  
│ │ ░ └ 📂 WEB-INF/  
│ │ ░ ░ └ 📜 [beans.xml](src/main/resources/WEB-INF/beans.xml)  
│ └ 📂 test/  
│ ░ ├ 📂 java/io/github/sealor/prototype/flyway/eclipselink/h2/glassfish/  
│ ░ │ └ 📜 [FlywayIT.java](src/test/java/io/github/sealor/prototype/flyway/eclipselink/h2/glassfish/FlywayIT.java)  
│ ░ └ 📂 resources/  
│ ░ ░ └ 📜 [glassfish-resources.xml](src/test/resources/glassfish-resources.xml)  
├ 📜 [LICENSE](LICENSE)  
├ 📜 [pom.xml](pom.xml)  
└ 📜 [README.md](README.md)  
