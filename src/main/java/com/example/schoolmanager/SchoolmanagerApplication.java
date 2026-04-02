# Port
server.port=${PORT:8080}

# Database (Render PostgreSQL)
spring.datasource.url=jdbc:postgresql://dpg-d6mokcftskes73e1pd90-a:5432/school_kbjz
spring.datasource.username=school_kbjz_user
spring.datasource.password=jdhjIHKVisnAteB9Etfc5f32LgGNr2Ln

spring.datasource.driver-class-name=org.postgresql.Driver

# JPA / Hibernate
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
