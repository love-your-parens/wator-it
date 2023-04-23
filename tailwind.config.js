/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "themes/konrad/layouts/**/*.html",
    "layouts/**/*.html",
  ],
  plugins: [],
  darkMode: 'class',
  theme: {
    extend: {
      backgroundImage: {
        'two-face-light': "url('/img/bg-photo.png')",
        'two-face-dark': "url('/img/bg-photo.png')",
        'two-face-outline': "url('/img/face-outlines.svg')",
      },
      fontFamily: {
        sans: '"Montserrat", sans-serif',
        serif: '"Hepta Slab", serif',
        display: '"Poiret One", cursive',
      },
      screens: {
        'panoramic': {
          'raw': '(min-width: 1024px) and (max-height: 400px)',
        },
      },
    },
  },
}
