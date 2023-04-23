/**
 * Development-only helper tools.
 */

var sLns = [...Array(9).keys()].map(x => Math.ceil(document.querySelector("#surname--stroke-" + ++x)?.getTotalLength()));

var wTime = 1.2;
var tOffset = 1;

var calcTime = (len) => Math.ceil(len * wTime / sLns[0] * 100) / 100;
var getTime = (strokeN) => calcTime(sLns[strokeN]);

var getDelay = (strokeN) => sLns.slice(0, strokeN).map(calcTime).reduce((a, b) => a + b, tOffset);

var totalTime = getDelay(10)

var summary = sLns.map((v, k) => {
    return {
        index: k + 1,
        length: v,
        animationTime: calcTime(v),
        animationDelay: getDelay(k),
        animationDelayPc: getDelay(k) / totalTime,
        animationTimePc: (getDelay(k) + calcTime(v)) / totalTime,
    }
})


var procureKeyframes = name => sLns.map((v, k) => {
    return `@keyframes ${name}-${k+1} {`
        + `0%,${Math.round(100 * getDelay(k) / totalTime)}% `
        + `{stroke-dasharray: ${v}; stroke-dashoffset: ${v};} `
        + `${Math.round(100 * (getDelay(k) + calcTime(v)) / totalTime)}% `
        + "{stroke-dashoffset: 0;}"
        + "}"
});