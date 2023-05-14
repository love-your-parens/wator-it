{
    // Initiate and synchronise Dark Mode controls.
    if (document.darkModeSwitchesPresent) {
        let addTransitions = (() => {
            let added = false; 
            return () => {
                if (!added) {
                    document.body.classList.add('transition-colors')
                    added = true
                }
            }
        })()
        let subscribers = document.querySelectorAll('html, input[type=checkbox].dark-mode-toggle')
        let toggle = (enabled) => {
            localStorage.darkMode = enabled ? "on" : "off"
            subscribers.forEach(
                (s) => s.dispatchEvent(new CustomEvent(
                    'darkModeToggle',
                    {'detail': {'enabled': enabled}}
                ))
            )
        }
        
        document.documentElement.addEventListener('darkModeToggle', function(e) {
            e.detail.enabled ? this.classList.add('dark') : this.classList.remove('dark')
        })

        document.querySelectorAll('input[type=checkbox].dark-mode-toggle').forEach((el) => {
            el.checked = false
            el.addEventListener('change', function() {
                toggle(this.checked)
                addTransitions()
            })
            el.addEventListener('darkModeToggle', function(event) {
                this.checked = event.detail.enabled
            })
        })

        // Explicit preference.
        if (localStorage.getItem('darkMode')) {
            toggle(localStorage.darkMode === 'on')
        }
        // Implicit preference.
        else if (window.matchMedia) {
            toggle(window.matchMedia('(prefers-color-scheme: dark)').matches)
        }
        // Default.
        else {
            toggle(false)
        }
    }

    // Add smooth scrolling to anchor links.
    document.querySelectorAll('a[href^="#"]').forEach(a => {
        a.addEventListener('click', (e)=> {
            let ref = a.getAttribute('href')
            document.querySelector(ref).scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            })
            history.pushState(null, null, ref)
            e.preventDefault()
        })
    })
}
