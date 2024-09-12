// scroll.js

// 1. <div id="bar"></div> 동적 추가
// 2. CSS 적용
// 3. 이벤트 적용
$('<div id="scroll-bar-indicator"></div>')
    .css({
        width: 0,
        height: '7px',
        'background-color': 'coral',
        position: 'fixed',
        top: 0
    })
    // .appendTo(부모)
    .prependTo('body');

$(document).scroll(function() {
    let x = 100 * $(document).scrollTop() / ($(document).outerHeight() - $(window).outerHeight());
    $('#scroll-bar-indicator').css('width', x + '%');
});