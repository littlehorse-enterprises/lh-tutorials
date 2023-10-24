<p align="center">
<img alt="LH" src="https://littlehorse.dev/img/logo.jpg" width="50%">
</p>

# LittleHorse Tutorials

This repository contains the cleaned-up code from the series of tutorial videos on our YouTube channel.

## Common Installation

Unless otherwise noted in the corresponding `README` of the specific tutorial, each tutorial code requires similar common setup.

### Install the CLI

Install the LittleHorse CLI via `homebrew` (tested on Mac and Linux):

```
brew install littlehorse-enterprises/lh/lhctl
```

Alternatively, if you have `go` but don't have homebrew, you can:

```
go install https://github.com/littlehorse-enterprises/littlehorse/lhctl@latest
```

### Get the LH Server

_NOTE: If you have obtained a private LH Cloud Sandbox, you can skip this step and just follow the configuration instructions you received from the LittleHorse Team (remember to set your environment variables!)._

To run a LittleHorse Server locally in one command, you can run:

```
docker run --name littlehorse -d -p 2023:2023 public.ecr.aws/littlehorse/lh-standalone:latest
```

Using the local LittleHorse Server takes about 15-25 seconds to start up, but it does not require any further configuration.

## Repo Map

* [**Create `TaskDef`**](./01-java-create-taskdef)
  * Register your first Task Definition (`TaskDef`) using Java!

