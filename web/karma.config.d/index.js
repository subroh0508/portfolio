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

// see: https://github.com/JetBrains/compose-multiplatform/blob/master/components/resources/library/karma.config.d/wasm/config.js
const path = require("path");

const basePath = path.resolve(__dirname, "../../../../web");
const resourcesPath = path.resolve(basePath, "build/processedResources/wasmJs/main");

config.proxies["/"] = resourcesPath;

config.files = [
  { pattern: path.resolve(resourcesPath, "**/*.cvr"), included: false, served: true, watched: false },
  { pattern: path.resolve(resourcesPath, "**/*.png"), included: false, served: true, watched: false },
  { pattern: path.resolve(resourcesPath, "**/*.jpg"), included: false, served: true, watched: false },
  { pattern: path.resolve(resourcesPath, "**/*.webp"), included: false, served: true, watched: false },
  { pattern: path.resolve(resourcesPath, "**/*.xml"), included: false, served: true, watched: false },
  { pattern: path.resolve(resourcesPath, "**/*.ttf"), included: false, served: true, watched: false },
].concat(config.files);
