FROM node:18.12-alpine AS build

WORKDIR /app

COPY . /app

RUN npm install -g @angular/cli@15.0.4 \
    && npm ci \
    && ng build --configuration=production

FROM nginx:1.23.3-alpine-slim

COPY --from=build /app/dist/city-list-front /usr/share/nginx/html

EXPOSE 80
