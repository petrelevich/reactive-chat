plugins {
    id("java")
    id("org.springframework.boot")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("org.webjars:webjars-locator-core")
    implementation("org.webjars:sockjs-client")
    implementation("org.webjars:stomp-websocket")
    implementation("org.webjars:bootstrap")
}


tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    compileTestJava {
        options.encoding = "UTF-8"
    }
}