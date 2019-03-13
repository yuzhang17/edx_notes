



## Introduction to Kubernetes

[TOC]



### Welcome & Introduction  
**Course Learning Objectives**
- The origin, architecture, primary components, and building blocks of Kubernetes.

- How to set up and access a Kubernetes cluster using Minikube.

- Ways to run applications on the deployed Kubernetes environment, and access the deployed applications.

- The usefulness of Kubernetes communities, and how you can participate.

### Chapter 1. Container Orchestration
#### 1.1.1Introduction and Learning Objectives  
##### 1.1.1 Introduction
With container images, we confine the application code, its runtime, and all of its dependencies in a pre-defined format. And, with container runtimes like runC, containerd, or rkt we can use those pre-packaged images, to create one or more containers. All of these runtimes are good at running containers on a single host. But, in practice, we would like to have a fault-tolerant and scalable solution, which can be achieved by creating a single controller/management unit, after connecting multiple nodes together. This controller/management unit is generally referred to as a container orchestrator. 

In this chapter, we will explore why we should use container orchestrators, different implementations of container orchestrators, and where to deploy them

##### 1.1.2 Learning Objectives
- Define the concept of container orchestration.
- Explain the reasons for doing container orchestration.
- Discuss different container orchestration options.
- Discuss different container orchestration deployment options.

#### 1.2Container Orchestration  
##### 1.2.1 What Are Containers? 
Containers are an application-centric way to deliver high-performing, scalable applications on the infrastructure of your choice.
With a container image, we bundle the application along with its runtime and dependencies. We use that image to create an isolated executable environment, also known as container. We can deploy containers from a given image on the platform of our choice, such as desktops, VMs, cloud, etc.
##### 1.2.2 What Is Container Orchestration
In the quality assurance (QA) environments, we can get away with running containers on a single host to develop and test applications. However, when we go to production, we do not have the same liberty, as we need to ensure that our applications:
- Are fault-tolerant
- Can scale, and do this on-demand
- Use resources optimally
- Can discover other applications automatically, and communicate with each other
- Are accessible from the external world 
- Can update/rollback without any downtime. 

Container orchestrators are the tools which group hosts together to form a cluster, and help us fulfill the requirements mentioned above.

每个需求对应的k8s中的功能时什么？

##### 1.2.3 Container Orchestrators
- Docker Swarm
 Docker Swarm is a container orchestrator provided by Docker, Inc. It is part of Docker Engine.
- Kubernetes
Kubernetes was started by Google, but now, it is a part of the Cloud Native Computing Foundation project.
- Mesos Marathon
Marathon is one of the frameworks to run containers at scale on Apache Mesos.
- Amazon ECS
Amazon EC2 Container Service (ECS) is a hosted service provided by AWS to run Docker containers at scale on its infrastructrue.
- Hashicorp Nomad
Nomad is the container orchestrator provided by HashiCorp.

##### 1.2.4 Why Use Container Orchestrators?

Container orchestrators can:

- Bring multiple hosts together and make them part of a cluster
- Schedule containers to run on different hosts
- Help containers running on one host reach out to containers running on other hosts in the cluster
- Bind containers and storage
- Bind containers of similar type to a higher-level construct, like services, so we don't have to deal with individual containers
- Keep resource usage in-check, and optimize it when necessary
- Allow secure access to applications running inside containers.
With all these built-in benefits, it makes sense to use container orchestrators to manage containers. In this course, we will explore Kubernetes. 

##### 1.2.5 Where to Deploy Container Orchestrators
Most container orchestrators can be deployed on the infrastructure of our choice. We can deploy them on bare metal, VMs, on-premise, or on a cloud of our choice. For example, Kubernetes can be deployed on our laptop/workstation, inside a company's datacenter, on AWS, on OpenStack, etc. There are even one-click installers available to set up Kubernetes on the cloud, like Google Kubernetes Engine on Google Cloud, or Azure Container Service on Microsoft Azure. Similar solutions are available for other container orchestrators, as well.

There are companies that offer managed Container Orchestration as a Service. We will explore them for Kubernetes in one of the later chapters

### Chapter 2. Kubernetes 
####  2.1Introduction and Learning Objectives  
##### 2.1.1 Introduction
In this chapter, we will explain what Kubernetes is, its features, and the reasons why one should use it. We will explore the evolution of Kubernetes from Borg, which is a cluster manager created by Google. 

We will also talk about the Cloud Native Computing Foundation (CNCF), which currently hosts the Kubernetes project, along with other cloud-native projects, like Prometheus, Fluentd, rkt, containerd, etc. 
##### 2.1.2 Learning Objectives
- Define Kubernetes.
- Explain the reasons for using Kubernetes.
- Discuss the features of Kubernetes.
- Discuss the evolution of Kubernetes from Borg.
- Explain what the Cloud Native Computing Foundation does.

#### 2.2 Kubernetes  
##### 2.2.1 What Is Kubernetes?
According to the Kubernetes website,

"Kubernetes is an open-source system for automating deployment, scaling, and management of containerized applications."

Kubernetes comes from the Greek word κυβερνήτης:, which means helmsman or ship pilot. With this analogy in mind, we can think of Kubernetes as the manager for shipping containers.

Generally, Kubernetes has new releases every three months. 
##### 2.2.2 From Borg to Kubernetes

some of the features/objects of Kubernetes that can be traced back to Borg, or to lessons learnt from it, are:

- API servers
- Pods
- IP-per-Pod
- Services
- Labels.

##### 2.2.3 Kubernetes Features I
Kubernetes offers a very rich set of features for container orchestration. Some of its fully supported features are:

- Automatic binpacking
Kubernetes automatically schedules the containers based on resource usage and constraints, without sacrificing the availability.

- Self-healing
Kubernetes automatically replaces and reschedules the containers from failed nodes. It also kills and restarts the containers which do not respond to health checks, based on existing rules/policy.

- Horizontal scaling
Kubernetes can automatically scale applications based on resource usage like CPU and memory. In some cases, it also supports dynamic scaling based on customer metrics.

- Service discovery and Load balancing
Kubernetes groups sets of containers and refers to them via a Domain Name System (DNS). This DNS is also called a Kubernetes service. Kubernetes can discover these services automatically, and load-balance requests between containers of a given service.

#####2.2.4 Kubernetes Features II
some other fully supported Kubernetes features are:
- Automated rollouts and rollbacks
Kubernetes can roll out and roll back new versions/configurations of an application, without introducing any downtime.
- Secrets and configuration management
Kubernetes can manage secrets and configuration details for an application without re-building the respective images. With secrets, we can share confidential information to our application without exposing it to the stack configuration, like on GitHub.
- Storage orchestration
With Kubernetes and its plugins, we can automatically mount local, external, and storage solutions to the containers in a seamless manner, based on software-defined storage (SDS).
- Batch execution
Besides long running jobs, Kubernetes also supports batch execution.

##### 2.2.5 Why Use Kubernetes
- We just looked at some of the fully-supported Kubernetes features. 
- We should also mention that Kubernetes is very portable and extensible. 
- Kubernetes can be deployed on the environment of our choice, be it VMs, bare metal, or public/private/hybrid/multi-cloud setups. Also, 
- Kubernetes has a very modular and pluggable architecture. We can write custom APIs or plugins to extend its functionalities.

For a successful open source project, the community is as important as having great code. Kubernetes has a very thriving community across the world. It has more than 1600 contributors, who, over time, have done over 62,000 commits. There are meet-up groups in different cities which meet regularly to discuss Kubernetes and its ecosystem. There are Special Interest Groups (SIGs), which focus on special interests, such as scaling, bare metal, networking, etc. We will talk more about them in our last chapter, Kubernetes Communities.

##### 2.2.6 Cloud Native Computing Foundation (CNCF)
The Cloud Native Computing Foundation (CNCF) is one of the projects hosted by The Linux Foundation. CNCF aims to accelerate the adoption of containers, microservices, and cloud-native applications.
CNCF hosts a set of projects, with more to be added in the future. CNCF provides resources to each of the projects, but, at the same time, each project continues to operate independently under its pre-existing governance structure and with its existing maintainers. At the time this course was created, the following projects were part of CNCF:

- containerd for container runtime
- rkt for container runtime
- Kubernetes for container orchestration
- Linkerd for service mesh
- Envoy for service mesh
- gRPC for remote procedure call (RPC)
- Container Network Interface (CNI) for networking API
- CoreDNS for service discovery
- Rook for cloud-native storage
- Notary for security
- The Update Framework (TUF) for software updates
- Prometheus for monitoring
- OpenTracing for tracing
- Jaeger for distributed tracing
- Fluentd for logging
- Vitess for storage.


 As we can see, this set of CNCF projects can cover the entire lifecycle of an application, from its execution using container runtimes, to its monitoring and logging. This is very important to meet the CNCF goal.

##### 2.2.7 CNCF and Kubernetes
For Kubernetes, the Cloud Native Computing Foundation:

- Provides a neutral home for the Kubernetes trademark and enforces proper usage
- Provides license scanning of core and vendored code
- Offers legal guidance on patent and copyright issues
-Creates open source curriculum, training, and certification
- Manages a software conformance working group
- Actively markets Kubernetes
- Hosts and funds developer marketing activities like K8Sport
- Supports ad hoc activities
- Funds conferences and meetup events.

### Chapter 3. Kubernetes Architecture - Overview  
#### 3.1 Introduction and Learning Objectives
##### 3.1.1 Introduction 
In this chapter, we will explore the Kubernetes architecture, the different components of the master and worker nodes, the cluster state management with etcd and the network setup requirements. We will also talk about the network specification called Container Network Interface (CNI), which is used by Kubernetes. 
##### 3.1.2 Learning Objectives
By the end of this chapter, you should be able to:

- Discuss the Kubernetes architecture.
- Explain the different components for master and worker nodes.
- Discuss about cluster state management with etcd.
- Review the Kubernetes network setup requirements.


#### 3.2 Kubernetes Architecture - Overview  
##### 3.2.1 Kubernetes Architecture
At a very high level, Kubernetes has the following main components:

One or more master nodes
One or more worker nodes
Distributed key-value store, like etcd.

![Kubernetes_Architecture.png](./Kubernetes_Architecture.png)

##### 3.2.2 Master Node
The master node is responsible for managing the Kubernetes cluster, and it is the entry point for all administrative tasks. We can communicate to the master node via the CLI, the GUI (Dashboard), or via APIs.

![Kubernetes_Master_Node.png](./Kubernetes_Master_Node.png)

For fault tolerance purposes, there can be more than one master node in the cluster. If we have more than one master node, they would be in a HA (High Availability) mode, and only one of them will be the leader, performing all the operations. The rest of the master nodes would be followers.

To manage the cluster state, Kubernetes uses etcd, and all master nodes connect to it. etcd is a distributed key-value store, which we will discuss in a little bit. The key-value store can be part of the master node. It can also be configured externally, in which case, the master nodes would connect to it.

##### 3.2.3 Master Node Components
A master node has the following components:

API server
Scheduler
Controller manager
etcd.
In the next few sections, we will discuss them in more detail.

##### 3.2.4 Master Node Components: API Server
All the administrative tasks are performed via the API server within the master node. A user/operator sends REST commands to the API server, which then validates and processes the requests. After executing the requests, the resulting state of the cluster is stored in the distributed key-value store.

##### 3.2.5 Master Node Components: Scheduler
As the name suggests, the scheduler schedules the work to different worker nodes. The scheduler has the resource usage information for each worker node. It also knows about the constraints that users/operators may have set, such as scheduling work on a node that has the label disk==ssd set. Before scheduling the work, the scheduler also takes into account the quality of the service requirements, data locality, affinity, anti-affinity, etc. The scheduler schedules the work in terms of Pods and Services.

##### 3.2.6 Master Node Components: Controller Manager
The controller manager manages different non-terminating control loops, which regulate the state of the Kubernetes cluster. Each one of these control loops knows about the desired state of the objects it manages, and watches their current state through the API server. In a control loop, if the current state of the objects it manages does not meet the desired state, then the control loop takes corrective steps to make sure that the current state is the same as the desired state.

##### 3.2.7 Master Node Components: etcd
As discussed earlier, etcd is a distributed key-value store which is used to store the cluster state. It can be part of the Kubernetes Master, or, it can be configured externally, in which case, master nodes would connect to it.

##### 3.2.8 Worker Node
A worker node is a machine (VM, physical server, etc.) which runs the applications using Pods and is controlled by the master node. Pods are scheduled on the worker nodes, which have the necessary tools to run and connect them. A Pod is the scheduling unit in Kubernetes. It is a logical collection of one or more containers which are always scheduled together. We will explore them further in later chapters.
![kubernetes_worker_node.png](./kubernetes_worker_node.png)

Also, to access the applications from the external world, we connect to worker nodes and not to the master node/s. We will dive deeper into this in future chapters. 

##### 3.2.9 Worker Node Components
A worker node has the following components:

- Container runtime
- kubelet
- kube-proxy

##### 3.2.10 Worker Node Components: Container Runtime
To run and manage a container's lifecycle, we need a container runtime on the worker node. Some examples of container runtimes are: 

- containerd
- rkt
- lxd. 
Sometimes, Docker is also referred to as a container runtime, but to be precise, Docker is a platform which uses containerd as a container runtime. 

##### 3.2.11 Worker Node Components: kubelet
The kubelet is an agent which runs on each worker node and communicates with the master node. It receives the Pod definition via various means (primarily, through the API server), and runs the containers associated with the Pod. It also makes sure that the containers which are part of the Pods are healthy at all times.

The kubelet connects to the container runtime using Container Runtime Interface (CRI). The Container Runtime Interface consists of protocol buffers, gRPC API, and libraries. 
![cri.png](./cri.png)
As shown above, the kubelet (grpc client) connects to the CRI shim (grpc server) to perform container and image operations. CRI implements two services: ImageService and RuntimeService. The ImageService is responsible for all the image-related operations, while the RuntimeService is responsible for all the Pod and container-related operations.

Container runtimes used to be hard-coded in Kubernetes, but with the development of CRI, Kubernetes can now use different container runtimes without the need to recompile. Any container runtime that implements CRI can be used by Kubernetes to manage Pods, containers, and container images.

##### 3.2.12 Worker Node Components: kubelet: CRI shims
Below you will find some examples of CRI shims:

- dockershim
With dockershim, containers are created using Docker installed on the worker nodes. Internally, Docker uses containerd to create and manage containers.
![cri.png](./cri.png)

- cri-containerd
With cri-containerd, we can directly use Docker's smaller offspring containerd to create and manage containers.

![cri_containerd.png](./cri_containerd.png)


- CRI-O
CRI-O enables using any Open Container Initiative (OCI) compatible runtimes with Kubernetes. At the time this course was created, CRI-O supported runC and Clear Containers as container runtimes. However, in principle, any OCI-compliant runtime can be plugged-in.

![cri-o.png](./cri-o.png)

##### 3.2.13 Worker Node Components: kube-proxy
Instead of connecting directly to Pods to access the applications, we use a logical construct called a Service as a connection endpoint. A Service groups related Pods and, when accessed, load balances to them. We will talk more about Services in later chapters.

kube-proxy is the network proxy which runs on each worker node and listens to the API server for each Service endpoint creation/deletion. For each Service endpoint, kube-proxy sets up the routes so that it can reach to it. We will also explore this in more detail in later chapters.

##### 3.2.14 State Management with etcd
As we mentioned earlier, Kubernetes uses etcd to store the cluster state. etcd is a distributed key-value store based on the Raft Consensus Algorithm. Raft allows a collection of machines to work as a coherent group that can survive the failures of some of its members. At any given time, one of the nodes in the group will be the master, and the rest of them will be the followers. Any node can be treated as a master.

![etcd-master-followers.png](./etcd-master-followers.png)

etcd is written in the Go programming language. In Kubernetes, besides storing the cluster state, etcd is also used to store configuration details such as subnets, ConfigMaps, Secrets, etc. 

##### 3.2.15 Network Setup Challenges
To have a fully functional Kubernetes cluster, we need to make sure of the following:

- A unique IP is assigned to each Pod
- Containers in a Pod can communicate to each other
- The Pod is able to communicate with other Pods in the cluster
- If configured, the application deployed inside a Pod is accessible from the external world.

All of the above are networking challenges which must be addressed before deploying the Kubernetes cluster. Next, we will see how we can solve these challenges.

##### 3.2.16 Assigning a Unique IP Address to Each Pod
In Kubernetes, each Pod gets a unique IP address. For container networking, there are two primary specifications:

- Container Network Model (CNM), proposed by Docker
- Container Network Interface (CNI), proposed by CoreOS.
Kubernetes uses CNI to assign the IP address to each Pod.

![cni.png](./cni.png)

The container runtime offloads the IP assignment to CNI, which connects to the underlying configured plugin, like Bridge or MACvlan, to get the IP address. Once the IP address is given by the respective plugin, CNI forwards it back to the requested container runtime.

##### 3.2.17 Container-to-Container Communication Inside a Pod

With the help of the underlying host operating system, all of the container runtimes generally create an isolated network entity for each container that it starts. On Linux, that entity is referred to as a **network namespace**. These network namespaces can be shared across containers, or with the host operating system.

##### 3.2.18 Pod-to-Pod Communication Across Nodes

In a clustered environment, the Pods can be scheduled on any node. We need to make sure that the Pods can communicate across the nodes, and all the nodes should be able to reach any Pod. Kubernetes also puts a condition that there shouldn't be any Network Address Translation (NAT) while doing the Pod-to-Pod communication across hosts. We can achieve this via:

- Routable Pods and nodes, using the underlying physical infrastructure, like Google Kubernetes Engine

- Using Software Defined Networking, like [Flannel](https://coreos.com/flannel/docs/latest/), [Weave](https://www.weave.works/oss/net/), [Calico](https://www.projectcalico.org/), etc. 

For more details, you can take a look at the available [Kubernetes documentation](https://kubernetes.io/docs/concepts/cluster-administration/networking/).

##### 3.2.19 Communication Between the External World and Pods

By exposing our services to the external world with **kube-proxy**, we can access our applications from outside the cluster. We will have a complete chapter dedicated to this, so we will dive into this later.

### 4. Installing Kubernetes

#### 4.1 Introduction

In this chapter, we will first discuss about the different configurations in which Kubernetes can be installed. We will then discuss about the infrastructure requirements to install Kubernetes, and we will also look at some of the tools which can help us with the installation. 

#### 4.2 Learning Objectives

By the end of this chapter, you should be able to:


- Discuss about the different Kubernetes configuration options.
- Discuss infrastructure considerations before installing Kubernetes.
- Discuss infrastructure choices for a Kubernetes deployment.
- Review Kubernetes installation tools and resources.

#### 4.3 Installing Kubernetes  

##### 4.3.1 Kubernetes Configuration

Kubernetes can be installed using different configurations. The four major installation types are briefly presented below:

- **All-in-One Single-Node Installation**
  With all-in-one, all the master and worker components are installed on a single node. This is very useful for learning, development, and testing. This type should not be used in production. Minikube is one such example, and we are going to explore it in future chapters.
- **Single-Node etcd, Single-Master, and Multi-Worker Installation**
  In this setup, we have a single master node, which also runs a single-node etcd instance. Multiple worker nodes are connected to the master node.
- **Single-Node etcd, Multi-Master, and Multi-Worker Installation**
  In this setup, we have multiple master nodes, which work in an HA mode, but we have a single-node etcd instance. Multiple worker nodes are connected to the master nodes.
- **Multi-Node etcd, Multi-Master, and Multi-Worker Installation**
  In this mode, etcd is configured in a clustered mode, outside the Kubernetes cluster, and the nodes connect to it. The master nodes are all configured in an HA mode, connecting to multiple worker nodes. This is the most advanced and recommended production setup.

##### 4.3.2 Infrastructure for Kubernetes Installation

Once we decide on the installation type, we also need to make some infrastructure-related decisions, such as:

- Should we set up Kubernetes on bare metal, public cloud, or private cloud?

- Which underlying system should we use? Should we choose RHEL, CoreOS, CentOS, or something else?
 Which networking solution should we use?
- And so on.

The Kubernetes documentation has details in regards to [choosing the right solution](https://kubernetes.io/docs/setup/pick-right-solution/). Next, we will take a closer look at these solutions.

##### 4.3.4 Localhost Installation

There are a few localhost installation options available to deploy single- or multi-node Kubernetes clusters on our workstation/laptop:

- [Minikube](https://kubernetes.io/docs/getting-started-guides/minikube/)
- [Ubuntu on LXD](https://kubernetes.io/docs/getting-started-guides/ubuntu/local/).

Minikube is the preferred and recommended way to create an all-in-one Kubernetes setup. We will be using it extensively in this course.

##### 4.3.5 On-Premise Installation

Kubernetes can be installed on-premise on VMs and bare metal.

- **On-Premise VMs**
  Kubernetes can be installed on VMs created via Vagrant, VMware vSphere, KVM, etc. There are different tools available to automate the installation, like [Ansible](https://www.ansible.com/) or [kubeadm](https://github.com/kubernetes/kubeadm).
- **On-Premise Bare Metal**Kubernetes can be installed on on-premise bare metal, on top of different operating systems, like RHEL, CoreOS, CentOS, Fedora, Ubuntu, etc. Most of the tools used to install VMs can be used with bare metal as well. 

##### 4.3.6 Cloud Installation

Kubernetes can be installed and managed on almost any cloud environment:

- **Hosted Solutions**With hosted solutions, any given software is completely managed by the provider. The user will just need to pay hosting and management charges. Some examples of vendors providing hosted solutions for Kubernetes are listed below:

  - [Google Kubernetes Engine (GKE)](https://cloud.google.com/container-engine/)
  -  [Azure Container Service (AKS)](https://azure.microsoft.com/en-us/services/container-service/)
  - [Amazon Elastic Container Service for Kubernetes (EKS) - Currently in Tech Preview](https://aws.amazon.com/eks/)
  - [OpenShift Dedicated](https://www.openshift.com/dedicated/)
  - [Platform9](https://platform9.com/support/kubernetes-at-the-command-line-up-and-running-with-kubectl/)
  - [IBM Cloud Container Service](https://console.ng.bluemix.net/docs/containers/container_index.html).

-**Turnkey Cloud Solutions**For Kubernetes, we have some Turnkey Cloud Solutions, with which Kubernetes can be installed with just a few commands on an underlying IaaS platform, such as:

  - [Google Compute Engine](https://kubernetes.io/docs/getting-started-guides/gce/)
  - [Amazon AWS](https://kubernetes.io/docs/getting-started-guides/aws/)
  - [Microsoft Azure](https://kubernetes.io/docs/getting-started-guides/azure/)
  - [Tectonic by CoreOS](https://coreos.com/tectonic).

- **Bare Metal**Kubernetes can be installed on bare metal provided by different cloud providers.

##### 4.3.7 Kubernetes Installation Tools/Resources

   -  **kubeadm**
      [kubeadm](https://github.com/kubernetes/kubeadm) is a first-class citizen on the Kubernetes ecosystem. It is a secure and recommended way to bootstrap the Kubernetes cluster. It has a set of building blocks to setup the cluster, but it is easily extendable to add more functionality. Please note that kubeadm does not support the provisioning of machines.
    - **KubeSpray**
      With [KubeSpray](https://github.com/kubernetes-incubator/kubespray) (formerly known as Kargo), we can install Highly Available Kubernetes clusters on AWS, GCE, Azure, OpenStack, or bare metal. KubeSpray is based on Ansible, and is available on most Linux distributions. It is a [Kubernetes Incubator](https://github.com/kubernetes-incubator/kargo) project.
    - **Kops**
      With [Kops](https://github.com/kubernetes/kops), we can create, destroy, upgrade, and maintain production-grade, highly-available Kubernetes clusters from the command line. It can provision the machines as well. Currently, AWS is officially supported. Support for GCE and VMware vSphere are in alpha stage, and other platforms are planned for the future.

If the existing solutions and tools do not fit your requirements, then [you can always install Kubernetes from scratch](https://kubernetes.io/docs/getting-started-guides/scratch/).

It is worth checking out the *Kubernetes The Hard Way* GitHub project by [Kelsey Hightower](https://twitter.com/kelseyhightower), which shares the manual steps involved in bootstrapping a Kubernetes cluster.



### 5. Setting Up a Single-Node Kubernetes Cluster with Minikube  

#### 5.1 Introduction and Learning Objectives  

##### 5.1.1  Introduction

As we mentioned in the previous chapter, Minikube is the easiest and most recommended way to run an all-in-one Kubernetes cluster locally. In this chapter, we will check out the requirements to install Minikube on our workstation, as well as the installation instructions to set it up on Linux, Mac, and Windows. 

##### 5.1.2  Learning Objectives

By the end of this chapter, you should be able to:

- Discuss Minikube.

- Install Minikube on Linux, Mac, and Windows.

- Verify the installation



###  6. Accessing Minikube

#### 6.1 Introduction and Learning Objectives  

##### 6.1.1 Introduction

Introductionz

In this chapter, we will study the different access methods to any Kubernetes cluster. We will use **kubectl** to access Minikube via **CLI**, the Kubernetes dashboard to access it via **GUI**, and the curl command, with the right credentials to access it via **APIs**.s

##### 6.1.2 API

By the end of this chapter, you should be able to:

- Review methods to access any Kubernetes cluster.
- Configure kubectl for Linux, macOS, and Windows.
- Access the Minikube dashboard.
- Access Minikube via APIs.

#### 6.2 Accessing Minikube  

##### 6.2.1 Accessing Minikube

Any healthy running Kubernetes cluster can be accessed via one of the following methods:

- Command Line Interface (CLI)
- Graphical User Interface (GUI)
- APIs.
  These methods are applicable to all Kubernetes clusters. 

##### 6.2.2 Accessing Minikube: Command Line Interface (CLI)

kubectl is the Command Line Interface (CLI) tool to manage the Kubernetes cluster resources and applications. In later chapters, we will be using kubectl to deploy the applications and manage the Kubernetes resources.

##### 6.2.3 Accessing Minikube: Graphical User Interface (GUI)

The Kubernetes dashboard provides the **Graphical User Interface (GUI)** to interact with its resources and containerized applications. In one of the later chapters, we will be using it to deploy a containerized application.

##### 6.2.4 Accessing Minikube: APIs

As we know, Kubernetes has the API server, and operators/users connect to it from the external world to interact with the cluster. Using both CLI and GUI, we can connect to the API server on the master node to perform different operations. We can directly connect to the API server using its API endpoints and send commands to it, as long as we can access the master node and have the right credentials.

Below, you can find a part of the HTTP API space of Kubernetes:

![http_api](http_api.png)

HTTP API space of Kubernetes can be divided into three independent groups:

- Core Group (/api/v1)
  This group includes objects such as Pods, Services, nodes, etc.
- Named Group
  This group includes objects in /apis/$NAME/$VERSION format. These different API versions imply different levels of stability and support:
  Alpha level - it may be dropped at any point in time, without notice. For example, /apis/batch/v2alpha1.
  Beta level - it is well-tested, but the semantics of objects may change in incompatible ways in a subsequent beta or stable release. For example, /apis/certificates.k8s.io/v1beta1.
  Stable level - appears in released software for many subsequent versions. For example, /apis/networking.k8s.io/v1.
- System-wide
  This group consists of system-wide API endpoints, like /healthz, /logs, /metrics, /ui, etc.

We can either connect to an API server directly via calling the respective API endpoints, or via the CLI/GUI.

Next, we will see how we can access the Minikube environment we set up in the previous chapter.

##### 6.2.5 kubectl

kubectl is generally installed before installing Minikube, but we can also install it later. There are different methods that can be used to install kubectl, which are mentioned in the Kubernetes documentation. Next, we will look at the steps to install kubectl on Linux, macOS, and Windows systems.

##### 6.2.6  Installing kubectl on Linux

To install kubectl on Linux, follow the instructions below:

Download the latest stable kubectl binary

$ curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl

Make the kubectl binary executable

$ chmod +x ./kubectl

Move the kubectl binary to the PATH

$ sudo mv ./kubectl /usr/local/bin/kubectl

##### 6.2.7 Installing kubectl on macOS

Use the following command

$ brew install kubectl

##### 6.2.8 kubectl Configuration File

To connect to the Kubernetes cluster, kubectl needs the master node endpoint and the credentials to connect to it. While starting Minikube, the startup process creates, by default, a configuration file, config, inside the.kube directory, which resides in the user's home directory. That configuration file has all the connection details. By default, the kubectl binary accesses this file to find the master node's connection endpoint, along with the credentials. To look at the connection details, we can either see the content of the ~/.kube/config(Linux) file, or run the following command:

$ kubectl config view
apiVersion: v1
clusters:
- cluster:
  certificate-authority: /Users/nkhare/.minikube/ca.crt
  server: https://192.168.99.100:8443
  name: minikube
  contexts:
- context:
  cluster: minikube
  user: minikube
  name: minikube
  current-context: minikube
  kind: Config
  preferences: {}
  users:
- name: minikube
  user:
    client-certificate: /Users/nkhare/.minikube/apiserver.crt
    client-key: /Users/nkhare/.minikube/apiserver.key

Once kubectl is installed, we can get information about the Minikube cluster with the kubectl cluster-info command: 

$ kubectl cluster-info
Kubernetes master is running at https://192.168.99.100:8443

To further debug and diagnose cluster problems, use 'kubectl cluster-info dump'.

You can find more details about the kubectl command line options here.



##### 6.2.9 Using the 'minikube dashboard' Command

As mentioned earlier, the Kubernetes dashboard provides the user interface for the Kubernetes cluster. To access the dashboard of Minikube, we can use minikube dashboard, which would open a new tab on our web browser, displaying the Kubernetes dashboard:

$ minikube dashboard



##### 6.2.10 Using the 'kubectl proxy' Command



Using the kubectl proxy command, kubectl would authenticate with the API server on the master node and would make the dashboard available on http://127.0.0.1:8001/api/v1/namespaces/kube-system/services/kubernetes-dashboard:/proxy/#!/overview?namespace=default, as the kubernetes-dashboard service runs inside the kube-system namespace.

$ kubectl proxy
Starting to serve on 127.0.0.1:8001

After running the above command, we can access the dashboard at http://127.0.0.1:8001/api/v1/namespaces/kube-system/services/kubernetes-dashboard:/proxy/#!/overview?namespace=default.



With the above curl request, we requested all the API endpoints from the API server.





### 7. Kubernetes Building Blocks  

#### 7.1 Introduction and Learning Objectives  

##### 7.1.1 Introduction

In this chapter, we will explore the Kubernetes object model and discuss some of its building blocks, such as Pods, ReplicaSets, Deployments, Namespaces, etc. We will also discuss the role of Labels and Selectors when it comes to grouping objects together. 

##### 7.1.2 Learning Objectives

By the end of this chapter, you should be able to:

- Review the Kubernetes object model.
- Discuss Kubernetes building blocks, e.g. Pods, ReplicaSets, Deployments, Namespaces.
- Discuss Labels and Selectors.

#### 7.2 Kubernetes Building Blocks  

##### 7.2.1 Kubernetes Object Model



Kubernetes has a very rich object model, with which it represents different persistent entities in the Kubernetes cluster. Those entities describe:

- What containerized applications we are running and on which node

- Application resource consumption

- Different policies attached to applications, like restart/upgrade policies, fault tolerance, etc.


With each object, we declare our intent or desired state using the spec field. The Kubernetes system manages the status field for objects, in which it records the actual state of the object. At any given point in time, the Kubernetes Control Plane tries to match the object's actual state to the object's desired state.

Examples of Kubernetes objects are Pods, ReplicaSets, Deployments, Namespaces, etc. We will explore them next.

To create an object, we need to provide the spec field to the Kubernetes API server. The spec field describes the desired state, along with some basic information, like the name. The API request to create the object must have the spec field, as well as other details, in a JSON format. Most often, we provide an object's definition in a.yaml file, which is converted by kubectl in a JSON payload and sent to the API server.

Below is an example of a Deployment object:

```yaml
apiVersion: apps/v1

kind: Deployment

metadata:

  name: nginx-deployment

  labels:

    app: nginx

spec:

  replicas: 3

  selector:

    matchLabels:

      app: nginx

  template:

    metadata:

      labels:

        app: nginx

    spec:

      containers:

      - name: nginx

        image: nginx:1.7.9

        ports:

        - containerPort: 80
```

With the apiVersion field in the example above, we mention the API endpoint on the API server which we want to connect to. With the kind field, we mention the object type - in our case, we have Deployment. With the metadata field, we attach the basic information to objects, like the name. You may have noticed that in our example we have two spec fields (spec and spec.template.spec). With spec, we define the desired state of the deployment. In our example, we want to make sure that, at any point in time, at least 3 Pods are running, which are created using the Pods Template defined in spec.template. In spec.template.spec, we define the desired state of the Pod. Here, our Pod would be created using nginx:1.7.9.

Once the object is created, the Kubernetes system attaches the status field to the object; we will explore it later.

Next, we will take a closer look at some of the Kubernetes objects, along with other building blocks.



##### 7.2.2 Pods

A Pod is the smallest and simplest Kubernetes object. It is the unit of deployment in Kubernetes, which represents a single instance of the application. A Pod is a logical collection of one or more containers, which:

- Are scheduled together on the same host
- Share the same network namespace
- Mount the same external storage (volumes).

![pod](pod.png)

Pods are **ephemeral in nature**, and they do not **have the capability to self-heal** by themselves. That is why we use them with controllers, **which can handle a Pod's replication, fault tolerance, self-heal**, etc. Examples of controllers are Deployments, ReplicaSets, ReplicationControllers, etc. We attach the Pod's specification to other objects using Pods Templates, as we have seen in the previous section.



##### 7.2.3 Labels

Labels are key-value pairs that can be attached to any Kubernetes objects (e.g. Pods). Labels are used to organize and select a subset of objects, based on the requirements in place. Many objects can have the same Label(s). Labels do not provide uniqueness to objects.

  ![labels](labels.png)

In the image above, we have used two Labels: app and env. Based on our requirements, we have given different values to our four Pods.

##### 7.2.4 Label Selectors

With Label Selectors, we can select a subset of objects. Kubernetes supports two types of Selectors:

- Equality-Based Selectors
  Equality-Based Selectors allow filtering of objects based on Label keys and values. With this type of selectors, we can use the =, ==, or != operators. For example, with env==dev we are selecting the objects where the env Label is set to dev. 
- Set-Based Selectors
  Set-Based Selectors allow filtering of objects based on a set of values. With this type of Selectors, we can use the in, notin, and exist operators. For example, with env in (dev,qa), we are selecting objects where the env Label is set to dev or qa.



##### 7.2.5 ReplicationControllers

A ReplicationController (rc) is a controller that is part of the master node's controller manager. It makes sure the specified number of replicas for a Pod is running at any given point in time. If there are more Pods than the desired count, the ReplicationController would kill the extra Pods, and, if there are less Pods, then the ReplicationController would create more Pods to match the desired count. **Generally, we don't deploy a Pod independently, as it would not be able to re-start itself, if something goes wrong**. We always use controllers like ReplicationController to create and manage Pods. 

##### 7.2.6 ReplicaSets 

A ReplicaSet (rs) is the next-generation ReplicationController. ReplicaSets support both equality- and set-based selectors, whereas ReplicationControllers only support equality-based Selectors. Currently, this is the only difference.

Next, you can see a graphical representation of a ReplicaSet, where we have set the replica count to 3 for a Pod.



A ReplicaSet (rs) is the next-generation ReplicationController. ReplicaSets support both equality- and set-based selectors, whereas ReplicationControllers only support equality-based Selectors. Currently, this is the only difference.

Next, you can see a graphical representation of a ReplicaSet, where we have set the replica count to 3 for a Pod.

The ReplicaSet will detect that the current state is no longer matching the desired state. So, in our given scenario, the ReplicaSet will create one more Pod, thus ensuring that the current state matches the desired state.



ReplicaSets can be used independently, but they are mostly used by Deployments to orchestrate the Pod creation, deletion, and updates. A Deployment automatically creates the ReplicaSets, and we do not have to worry about managing them. 

We will take a closer look at Deployments next.

##### 7.2.7 Deployments

Deployment objects provide declarative updates to Pods and ReplicaSets. The DeploymentController is part of the master node's controller manager, and it makes sure that the current state always matches the desired state.

In the following example, we have a Deployment which creates a ReplicaSet A. ReplicaSet A then creates 3 Pods. In each Pod, one of the containers uses the nginx:1.7.9 image.



Now, in the Deployment, we change the Pods Template and we update the image for the nginx container from nginx:1.7.9 to nginx:1.9.1. As have modified the Pods Template, a new ReplicaSet B gets created. This process is referred to as a Deployment rollout.

**A rollout is only triggered when we update the Pods Template for a deployment.** Operations like scaling the deployment do not trigger the deployment.

Once ReplicaSet B is ready, the Deployment starts pointing to it.



On top of ReplicaSets, **Deployments provide features like Deployment recording,** with which, if something goes wrong, we can rollback to a previously known state.



##### 7.2.8 Namespaces



If we have numerous users whom we would like to organize into teams/projects, we can partition the Kubernetes cluster into sub-clusters using Namespaces. The names of the resources/objects created inside a Namespace are unique, but not across Namespaces.

To list all the Namespaces, we can run the following command:

$ kubectl get namespaces
NAME          STATUS       AGE
default       Active       11h
kube-public   Active       11h
kube-system   Active       11h

Generally, Kubernetes creates two default Namespaces: kube-system and default. The **kube-system** Namespace contains the objects created by the Kubernetes system. The default Namespace contains the objects which belong to any other Namespace. By default, we connect to the default Namespace. **kube-public** is a special Namespace, which is readable by all users and used for special purposes, like bootstrapping a cluster. 

Using **Resource Quotas**, we can divide the cluster resources within Namespaces. We will briefly cover resource quotas in one of the future chapters.





### 8. Authentication, Authorization, Admission Control

#### 8.1 Introduction and Learning Objectives  

##### 8.1.1  Introduction

In this chapter, we will be looking into the Authentication, Authorization and Admission Control stages of Kubernetes API requests. 

##### 8.1.2 Learning Objectives

By the end of this chapter, you should be able to:

- Discuss authentication, authorization, and access control stages of the Kubernetes API access.
- Understand the different kinds of Kubernetes users.
- Explore the different modules for authentication and authorization.

#### 8.2  Authentication, Authorization, and Admission Control  

##### 8.2.1 Authentication, Authorization, and Admission Control - Overview

To access and manage any resources/objects in the Kubernetes cluster, we need to access a specific API endpoint on the API server. Each access request goes through the following three stages:

- Authentication

  Logs in a user.

- Authorization
    Authorizes the API requests added by the logged-in user.

- Admission Control
    Software modules that can modify or reject the requests based on some additional checks, like Quota.

![auth](auth.png)

##### 8.2.2  Authentication I

Kubernetes does not have an object called user, nor does it store usernames or other related details in its object store. However, even without that, Kubernetes can use usernames for access control and request logging, which we will explore in this chapter.

Kubernetes has two kinds of users:

- Normal Users
  They are managed outside of the Kubernetes cluster via independent services like User/Client Certificates, a file listing usernames/passwords, Google accounts, etc.

- Service Accounts
  With Service Account users, in-cluster processes communicate with the API server to perform different operations. Most of the Service Account users are created automatically via the API server, but they can also be created manually. The Service Account users are tied to a given Namespace and mount the respective credentials to communicate with the API server as Secrets.

If properly configured, Kubernetes can also support anonymous requests, along with requests from Normal Users and Service Accounts.

##### 8.2.3 Authentication II

For authentication, Kubernetes uses different authenticator modules:

- Client Certificates
  To enable client certificate authentication, we need to reference a file containing one or more certificate authorities by passing the --client-ca-file=SOMEFILE option to the API server. The certificate authorities mentioned in the file would validate the client certificates presented to the API server. A demonstration video covering this topic is also available at the end of this chapter.
- Static Token File
  We can pass a file containing pre-defined bearer tokens with the --token-auth-file=SOMEFILE option to the API server. Currently, these tokens would last indefinitely, and they cannot be changed without restarting the API server.
- Bootstrap Tokens
  This feature is currently in an alpha status, and is mostly used for bootstrapping a new Kubernetes cluster.
- Static Password File
  It is similar to Static Token File. We can pass a file containing basic authentication details with the --basic-auth-file=SOMEFILE option. These credentials would last indefinitely, and passwords cannot be changed without restarting the API server.
- Service Account Tokens
  This is an automatically enabled authenticator that uses signed bearer tokens to verify the requests. These tokens get attached to Pods using the ServiceAccount Admission Controller, which allows in-cluster processes to talk to the API server.
- OpenID Connect Tokens
  OpenID Connect helps us connect with OAuth 2 providers, such as Azure Active Directory, Salesforce, Google, etc., to offload the authentication to external services.
- Webhook Token Authentication
  With Webhook-based authentication, verification of bearer tokens can be offloaded to a remote service.
- Keystone Password
  Keystone authentication can be enabled by passing the --experimental-keystone-url=<AuthURL> option to the API server, where AuthURL is the Keystone server endpoint.
- Authenticating Proxy
  If we want to program additional authentication logic, we can use an authenticating proxy. 

We can enable multiple authenticators, and the first module to successfully authenticate the request short-circuits the evaluation. In order to be successful, you should enable at least two methods: **the service account tokens authenticator** and **the user authenticator.**



##### 8.2.4  Authorization I

After a successful authentication, users can send the API requests to perform different operations. Then, those API requests get authorized by Kubernetes using various authorization modules.

Some of the API request attributes that are reviewed by Kubernetes include user, group, extra, Resource or Namespace, to name a few. Next, these attributes are evaluated against policies. If the evaluation is successful, then the request will be allowed, otherwise it will get denied. Similar to the Authentication step, Authorization has multiple modules/authorizers. More than one module can be configured for one Kubernetes cluster, and each module is checked in sequence. If any authorizer approves or denies a request, then that decision is returned immediately.

Next, we will discuss the authorizers that are supported by Kubernetes.



##### 8.2.5 Authorization II

- Node Authorizer
  Node authorization is a special-purpose authorization mode which specifically authorizes API requests made by kubelets. It authorizes the kubelet's read operations for services, endpoints, nodes, etc., and writes operations for nodes, pods, events, etc. For more details, please review the Kubernetes documentation.
- Attribute-Based Access Control (ABAC) Authorizer
  With the ABAC authorizer, Kubernetes grants access to API requests, which combine policies with  attributes. In the following example, user nkhare can only read Pods in the Namespace lfs158.

{
  "apiVersion": "abac.authorization.kubernetes.io/v1beta1",
  "kind": "Policy",
  "spec": {
    "user": "nkhare",
    "namespace": "lfs158",
    "resource": "pods",
    "readonly": true
  }
}

To enable the ABAC authorizer, we would need to start the API server with the --authorization-mode=ABAC option. We would also need to specify the authorization policy, like --authorization-policy-file=PolicyFile.json. For more details, please review the Kubernetes documentation.

- Webhook Authorizer
  With the Webhook authorizer, Kubernetes can offer authorization decisions to some third-party services, which would return true for successful authorization, and false for failure. In order to enable the Webhook authorizer, we need to start the API server with the --authorization-webhook-config-file=SOME_FILENAME option, where SOME_FILENAME is the configuration of the remote authorization service. For more details, please see the Kubernetes documentation.

##### 8.2.6 Authorization III

Role-Based Access Control (RBAC) Authorizer
In general, with RBAC we can regulate the access to resources based on the roles of individual users. In Kubernetes, we can have different roles that can be attached to subjects like users, service accounts, etc. While creating the roles, we restrict resource access by specific operations, such as create, get, update, patch, etc. These operations are referred to as verbs.

In RBAC, we can create two kinds of roles:

Role
With Role, we can grant access to resources within a specific Namespace.

ClusterRole
The ClusterRole can be used to grant the same permissions as Role does, but its scope is cluster-wide.

In this course, we will focus on the first kind, Role. Below you will find an example:

kind: Role
apiVersion: rbac.authorization.k8s.io/v1
metadata:
  namespace: lfs158
  name: pod-reader
rules:
- apiGroups: [""] # "" indicates the core API group
  resources: ["pods"]
  verbs: ["get", "watch", "list"]

As you can see, it creates a pod-reader role, which has access only to the Pods of lfs158 Namespace. Once the role is created, we can bind users with RoleBinding.

There are two kinds of RoleBindings:

RoleBinding
It allows us to bind users to the same namespace as a Role. We could also refer a ClusterRole in RoleBinding, which would grant permissions to Namespace resources defined in the ClusterRole within the RoleBinding’s Namespace.

ClusterRoleBinding
It allows us to grant access to resources at a cluster-level and to all Namespaces.

In this course, we will focus on the first kind, RoleBinding. Below, you will find an example:

kind: RoleBinding
apiVersion: rbac.authorization.k8s.io/v1
metadata:
  name: pod-read-access
  namespace: lfs158
subjects:
- kind: User
  name: nkhare
  apiGroup: rbac.authorization.k8s.io
  roleRef:
  kind: Role
  name: pod-reader
  apiGroup: rbac.authorization.k8s.io

As you can see, it gives access to nkhare to read the Pods of lfs158 Namespace.

To enable the RBAC authorizer, we would need to start the API server with the --authorization-mode=RBAC option. With the RBAC authorizer, we dynamically configure policies. For more details, please review the Kubernetes documentation.



##### 8.2.7 Admission Control

Admission control is used to specify granular access control policies, which include allowing privileged containers, checking on resource quota, etc. We force these policies using different admission controllers, like ResourceQuota, AlwaysAdmit, DefaultStorageClass, etc. They come into effect only after API requests are authenticated and authorized.

To use admission controls, we must start the Kubernetes API server with the admission-control, which takes a comma-delimited, ordered list of controller names, like in the following example:

--admission-control=NamespaceLifecycle,ResourceQuota,PodSecurityPolicy,DefaultStorageClass.

By default, Kubernetes comes with some built-in admission controllers. For more details, please review the Kubernetes documentation.



### 9. Services  

#### 9.1 Introduction and Learning Objectives  

##### 9.1.1 Introduction

In this chapter, we will learn about Services, using which we can group Pods to provide common access points from the external world. We will learn about the kube-proxy daemon, which runs on each worker node to provide access to services. We will also discuss about service discovery and service types, which decide the access scope of a service.

##### 9.1.2  Learning Objectives

By the end of this chapter, you should be able to:

- Discuss the benefits of grouping Pods into Services to access an application.
- Explain the role of the kube-proxy daemon running on each worker node.
- Explore the Service discovery options available in Kubernetes.
- Discuss different Service types.

#### 9.2  Services

##### 9.2.1 Connecting Users to Pods

To access the application, a user/client needs to connect to the Pods. As Pods are **ephemeral in nature**, resources like IP addresses allocated to it cannot be static. Pods could die abruptly or be rescheduled based on existing requirements.

Let's take, for example, a scenario in which a user/client is connected to a Pod using its IP address.

Unexpectedly, the Pod to which the user/client is connected dies, and a new Pod is created by the controller. The new Pod will have a new IP address, which will not be known automatically to the user/client of the earlier Pod.

##### 9.2.2 Services

For example, in the following graphical representation we have used the app keyword as a Label, and frontend and db as values for different Pods.



Using selectors (app==frontend and app==db), we can group them into two logical groups: one with 3 Pods, and one with just one Pod.

We can assign a name to the logical grouping, referred to as a Service name. In our example, we have created two Services, frontend-svc and db-svc, and they have the app==frontend and the app==db Selectors, respectively.

