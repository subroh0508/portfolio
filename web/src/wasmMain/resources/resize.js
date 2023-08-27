function resizeCanvas(_event) {
  const canvas = document.getElementById('ComposeTarget');

  canvas.style.width = window.innerWidth + 'px';
  canvas.style.height = window.innerHeight + 'px';

  canvas.width = window.innerWidth;
  canvas.height = window.innerHeight;
}

window.addEventListener('load', resizeCanvas);
window.addEventListener('resize', resizeCanvas);
