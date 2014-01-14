// require hogan
var hogan = require("hogan.js");

// construct template string
var template = "Hello {{world}}!";

// compile template
var hello = hogan.compile(template);

console.log(hello);

/**
 * Reads and compiles hogan templates from the shared template directory to
 * stringified javascript functions.
 */
function readSharedTemplates() {
	var sharedTemplateFiles = fs.readdirSync(sharedTemplateDirectory);

	// Here we'll stash away the shared templates compiled script (as a string)
	// and the name of the template.
	app.sharedTemplates = [];

	// Hogan like it's partials as template contents rather than a path to the
	// template file
	// so we'll stash each template in a partials object so they're available
	// for use
	// in other templates.
	app.sharedPartials = {};

	// Iterate over each sharedTemplate file and compile it down to a javascript
	// function which can be
	// used on the client
	sharedTemplateFiles
			.forEach(function(template, i) {
				var functionName = template
						.substr(0, template.lastIndexOf(".")), fileContents = removeByteOrderMark(fs
						.readFileSync(sharedTemplateDirectory + template,
								"utf8"));

				// Stash the partial reference.
				app.sharedPartials[functionName] = fileContents;
				// Stash the compiled template reference.
				app.sharedTemplates.push({
					id : functionName,
					script : hogan.compile(fileContents, {
						asString : true
					}),
					// Since mustache doesn't boast an 'isLast' function we need
					// to do that here instead.
					last : i === sharedTemplateFiles.length - 1
				});
			});
}