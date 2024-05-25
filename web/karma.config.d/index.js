// Workaround: https://youtrack.jetbrains.com/issue/KT-67468
function KarmaWebpackOutputFramework(config) {
  // This controller is instantiated and set during the preprocessor phase.
  const controller = config.__karmaWebpackController;

  // only if webpack has instantiated its controller
  if (!controller) {
    console.warn(
      "Webpack has not instantiated controller yet.\n" +
      "Check if you have enabled webpack preprocessor and framework before this framework"
    )
    return
  }

  config.files.push({
    pattern: `${controller.outputPath}/**/*`,
    included: false,
    served: true,
    watched: false,
  })
}

const KarmaWebpackOutputPlugin = {
  'framework:webpack-output': ['factory', KarmaWebpackOutputFramework],
};

config.plugins.push(KarmaWebpackOutputPlugin);
config.frameworks.push("webpack-output");

// see: https://youtrack.jetbrains.com/issue/KT-42923
const PROJECT_PATH = require('path').resolve(__dirname, '../../../../web');

config.middleware = config.middleware || [];
config.middleware.push('resource-loader');

function ResourceLoaderMiddleware() {
  const fs = require('fs');

  return function (request, response, next) {
    const content = fs.readFileSync(PROJECT_PATH + '/build/processedResources/wasmJs/main' + decodeURI(request.originalUrl));
    response.writeHead(200);
    response.end(content);
  }
}

config.plugins.push({
  'middleware:resource-loader': ['factory', ResourceLoaderMiddleware]
});
