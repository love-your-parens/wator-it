# wator.it
## My personal website

Notes below pertain to site development.

### Requirements

To get started, you need the following installed on your system:

* [Hugo](https://gohugo.io)
* [Babashka](https://babashka.org)
* [NPM](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)

Before starting the project, resolve its `npm` dependencies by running `npm install`.

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

### Staging and publishing

You can publish the site to a remote server automatically via `S/FTP` or `SSH`, so long as you have the appropriate command-line client installed on your system:

* To upload via FTP/SFTP, you'll need `lftp`
* To upload via SSH, you'll need `rsync`

To replace `rsync` on Windows, you can install [cwrsync](https://itefix.net/cwrsync) (e.g. via [Scoop](https://scoop.sh/)). Scoop also offers an easy install of `lftp`.

`Firebase` deployments are also supported, but to this end the `Firebase CLI` must be installed and configured separately within the project as documented [here](https://firebase.google.com/docs/hosting/quickstart?hl=en&authuser=0).

You can publish the site to one of the two endpoints:
- staging: via the `stage` task
- production: via the `publish` task

For this to work, you need to provide an appropriate configuration file for each of the endpoints: `stage.edn` and `publish.edn` respectively, both located in the project's root.

Configuration files should consist of a hashmap, containing some of the parameters listed below.

Mandatory:

* `method` program/protocol to use. Available options:
  - :ftp
  - :sftp
  - :ssh
  - :firebase

Mandatory with S/FTP and SSH:

* `host`
* `user`
* `password`
* `path` - path of the target directory, e.g. `www/` (relative), or `/home/myuser/www` (absolute)
