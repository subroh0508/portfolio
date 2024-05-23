if (config.mode === 'development' && config.devServer) {
  config.devServer.historyApiFallback = true;
}
