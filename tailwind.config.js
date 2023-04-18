/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "themes/konrad/layouts/**/*.html",
    "layouts/**/*.html",
  ],
  theme: {
    extend: {
      backgroundImage: {
        'two-face-light': "url('/img/bg-photo.png')",
        'two-face-dark': "url('/img/bg-photo.png')",
        'two-face-outline': "url('/img/face-outlines.svg')",
      }
    },
    screens: {
      '2xl': '1440px',
    },
    keyframes: {
      shimmer: {
        '0%, 100%': {
          transform: 'translateX(5px) translateY(-5px)',
        },
        '50%': {
          transform: 'translateX(-5px) translateY(5px)',
        },
      }
    },
    animation: {
      shimmer: 'shimmer 9s ease-in-out infinite',
    }
  },
  plugins: [],
  darkMode: 'class',
}
