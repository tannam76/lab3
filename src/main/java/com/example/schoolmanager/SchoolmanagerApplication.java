# Use Render (or any cloud) provided environment variables when available.
# Local defaults are kept for local development.
server.port=${PORT:8080}

# Default local Postgres settings (for dev). Override with env vars in Render/Prod.
# Example: postgresql://user:pass@host:5432/dbname
spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/school}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:postgres}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:postgres}

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
