# wator.it
## My personal website

Notes below pertain to site development.

### Requirements

To get started, you need the following installed on your system:

* [Hugo](https://gohugo.io)
* [Babashka](https://babashka.org)
* [Tailwind](https://tailwindcss.com)

### Project management

Common tasks are delivered using Babashka's task-runner. To see the full list, navigate to the project's root and run:

```sh
bb tasks
```

### Development

Start the development task:

```sh
bb develop
``` 

This pre-builds the project, launches a local development HTTP server, and monitors changes with live-reload.

Development subtasks can also be run individually, like so:

```sh
bb develop:hiccup
```

### Building

Simply run:

```sh
bb build
```

The site will reside in the `public` directory.

### Publishing

You can publish the site to a remote server automatically via `S/FTP` or `SSH`, so long as you have the appropriate command-line client installed on your system:

* To upload via FTP/SFTP, you'll need `lftp`
* To upload via SSH, you'll need `rsync`

To replace `rsync` on Windows, you can install [cwrsync](https://itefix.net/cwrsync) (e.g. via [Scoop](https://scoop.sh/)). Scoop also offers an easy install of `lftp`.

Put your FTP credentials in a `publish.edn` file, located in the project's root. Create it if it doesn't exist. It should contain the following keys:

* `host` 
* `user`
* `password`
* `path` - path of the target directory, e.g. `www/` (relative), or `/home/myuser/www` (absolute)
* `method` program/protocol to use. Available options:
  * :ftp
  * :sftp
  * :ssh
