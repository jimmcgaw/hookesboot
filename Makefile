
debug:
	./gradlew bootRun

# build a "cloud-native buildpack"
image:
	./gradlew bootBuildImage

test:
	./gradlew test

build:
	docker compose build

start:
	docker compose up -d

stop:
	docker compose down