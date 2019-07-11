let portfolio = document.getElementById("portfolio");

anime({
    targets: portfolio,
    translateX: [
        {value: -40, duration: 1000},
        {value: 0, duration: 1000},
        {value: 0, delay: 2000}
    ],

    easing: 'linear',
    // direction: 'reverse',
    loop: true
});

let github = document.getElementById("github");

anime({
    targets: github,
    translateX: [
        {value: 40, duration: 1000},
        {value: 0, duration: 1000},
        {value: 0, delay: 2000}
    ],
    easing: 'linear',
    // direction: 'reverse',
    loop: true
});