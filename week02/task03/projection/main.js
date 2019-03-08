let body = document.querySelector("body");
let main = document.querySelector("main");


function createProjectionOfMain() {
  let { offsetWidth: bodyWidth,
        offsetHeight: bodyHeight } = body;
  let { offsetTop: mainOffsetTop,
        offsetLeft: mainOffsetLeft,
        offsetWidth: mainWidth,
        offsetHeight: mainHeight } = main;
  let canvas = document.createElement('canvas');
  let context = canvas.getContext("2d");

  canvas.width = bodyWidth;
  canvas.height = bodyHeight;
  context.fillStyle = "#7AA5CE";
  context.fillRect(0, 0, bodyWidth, bodyHeight);

  context.beginPath();
  context.fillStyle = "#739CC4";
  context.moveTo(mainOffsetLeft+mainWidth, mainOffsetTop);
  context.lineTo(mainOffsetLeft+mainWidth, mainOffsetTop+mainHeight);
  context.lineTo(mainOffsetLeft, mainOffsetTop+mainHeight);
  context.lineTo(mainOffsetLeft+0.1*mainWidth, bodyHeight);
  context.lineTo(bodyWidth, bodyHeight);
  context.lineTo(bodyWidth, mainOffsetTop+0.2*mainHeight);
  context.closePath();
  context.fill();
  body.style.backgroundImage = `url(${canvas.toDataURL()})`;
}


window.addEventListener("load", createProjectionOfMain);
window.addEventListener("resize", createProjectionOfMain);
