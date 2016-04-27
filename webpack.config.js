/* eslint-env node */
"use strict";

let path = require("path");

module.exports = {
	entry: "./src/main/frontend/index.js",
	output: {
		path: path.join(__dirname, "src/main/resources/static"),
		filename: "application.js"
	},
	resolve: {
		root: path.resolve("./node_modules")
	},
	module: {
		loaders: [{
			loader: "babel-loader",
			query: {
				presets: ["es2015"],
				cacheDirectory: true
			}
		}]
	}
};
