# Dynamo Pages Template Setup Guide

## Overview

This guide walks through setting up your Dynamo Pages app using Docker Compose and manually building the application. It also covers how to set up authentication using Keycloak.



| Release Name | Description | Release Date |
|----|----|----|
| MVP - 1.0.0 | Dynamo Pages allows you to create, edit, and delete collections and documents seamlessly. | 27-09-2024 |
|    |    |    |


---

## Using Docker Compose

### Prerequisites

Before starting, ensure the following are installed and available on your system:

* **Docker** or **Docker Desktop -**  (Docker Version - 20.10.x and above)
* Open ports: **8080**, **8081**, **3000**, **5432 -** Ensure that the following ports are not in use:

### 1.1 Setup with Docker Compose

1. Navigate to the project folder in your terminal.
2. Run the following command to start the Docker containers:

   ```bash
   docker compose up
   ```

   This command will pull and download the necessary containers, and the client will run on [localhost:3000](http://localhost:3000).
3. Default Credentials for client app - **Username**: dev@breezeware.net **Password**: breeze123 or Signup.
4. Application Port
   * **Backend Server** - 8081
   * **Frontend Client -** 3000
   * **Auth Server -** 8080

### 1.2 If Docker not installed - Docker Installation

#### **For Docker on Linux:**

1. Update your packages:

   ```bash
   sudo apt-get update
   ```
2. Install Docker using:

   ```bash
   sudo apt install docker.io
   ```
3. Verify installation:

   ```bash
   docker --version
   ```

#### **For Docker Desktop on Mac/Windows:**

1. Download and install Docker Desktop from [here](https://www.docker.com/products/docker-desktop).
2. Follow the installation instructions and start Docker Desktop.

### 1.3 Troubleshooting

#### Checking and Managing Active Ports

Ensure that the following ports are not in use:

* **8080**
* **8081**
* **3000**
* **5432**

If any of these ports are active, you need to free them by killing the respective processes. You can check for active ports using:

```bash
lsof -i :<port_number>
```

To kill a process on a specific port:

```bash
kill -9 <process_id>
```

#### If you encounter file permission issues, use the following command:

```bash
sudo chown -R $USER:$USER postgres-data/
```

#### If this doesn’t resolve the issue, try:

* Resetting changes with Git:

  ```bash
  git checkout .
  ```
* Deleting the project and re-cloning it.

#### If you encounter Error response from daemon: pull access denied for public.ecr.aws, use the following command:

```bash
docker logout public.ecr.aws
```



---

## Additional Notes

* Always verify that no other processes are using ports **8080**, **8081**, **3000**, or **5432** before running the services.
* If you encounter issues with ports, repeat the process to kill active ports as mentioned above.


---

This completes the setup for the Dynamo Pages Template. If further issues arise, refer to the troubleshooting section or restart from the initial steps.


## Features

* **Manage Collections**: \n Easily create, edit, and organize collections within other collections. This feature allows efficient structuring and grouping of related items for easy access and management.
* **Manage Documents**: \n Add, edit, and remove documents within collections. Documents can be nested, categorized, and updated as needed, providing seamless control over content within your collections.
* **Home Screen Viewing**: \n Access an overview of your collections and documents directly from the home screen. Quickly navigate to specific collections or documents for efficient, intuitive management.
* **Document Version Management**: \n Keep track of document changes over time. Manage different versions, review historical edits, and restore previous versions to ensure accuracy and consistency.
* **Archive Feature**: \n Archive old or unused documents and collections for future reference. Keep your workspace clean and organized while retaining the ability to access archived content when needed.


## Application Screenshots

 ![](/api/attachments.redirect?id=7791dfeb-5a7d-4f33-b5b6-a84345aadc49)

 ![](/api/attachments.redirect?id=1f169fd1-8dcc-44ff-9475-a6030156b52b)


 ![](/api/attachments.redirect?id=a3842228-a413-499d-896e-33c38f1ba067)

 ![](/api/attachments.redirect?id=1e6b6f98-d8ae-4ea8-8096-20a93186d3d9)

 ![](/api/attachments.redirect?id=5d71255e-e4be-4c09-b2e2-28d581592172)


\

\

 ![](/api/attachments.redirect?id=29aa5de7-6573-46d9-b8b3-6debece4617d)


## Support

For any **business inquiries**, **technical support**, or to report issues, please contact support@breezeware.net.