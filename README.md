# LVM LAS Postbox

You need to have Java 8 and Maven installed.

Run with:

```
npm install
npm run compile
mvn spring-boot:run
```

Package with:

```
npm install
npm run compile
mvn package

java -jar target/lvm-las-postbox-0.1.0-SNAPSHOT.jar
```

Now you can visit http://localhost:9000 to see the application.

During development you can run `vagrant rsync-auto` to copy all changes you make to
the code into the box.

## JavaScript

You need to have Node.js (5.X.X) installed. Run `npm install` to install all dependencies.
Then you have the following tasks available:

* `npm run lint`: Lint the JavaScript files
* `npm run compile`: Compile the JavaScript and CSS files
* `npm run assets`: Copy the assets (images and fonts) to this project
* `npm run webpack`: Compile the JavaScript files
* `npm run webpack-watch`: Watch the JavaScript files and compile on every change
* `npm run less`: Compile the CSS files
* `npm run less-watch`: Watch the CSS files and compile on every change
