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

#### 4. Installing Kubernetes

##### 4.1 Introduction

In this chapter, we will first discuss about the different configurations in which Kubernetes can be installed. We will then discuss about the infrastructure requirements to install Kubernetes, and we will also look at some of the tools which can help us with the installation. 

##### 4.2 Learning Objectives

By the end of this chapter, you should be able to:


- Discuss about the different Kubernetes configuration options.
- Discuss infrastructure considerations before installing Kubernetes.
- Discuss infrastructure choices for a Kubernetes deployment.
- Review Kubernetes installation tools and resources.

##### 4.3 Installing Kubernetes  

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

- - - **Hosted Solutions**With hosted solutions, any given software is completely managed by the provider. The user will just need to pay hosting and management charges. Some examples of vendors providing hosted solutions for Kubernetes are listed below:

- - - - - [Google Kubernetes Engine (GKE)](https://cloud.google.com/container-engine/)
        - [Azure Container Service (AKS)](https://azure.microsoft.com/en-us/services/container-service/)
        - [Amazon Elastic Container Service for Kubernetes (EKS) - Currently in Tech Preview](https://aws.amazon.com/eks/)
        - [OpenShift Dedicated](https://www.openshift.com/dedicated/)
        - [Platform9](https://platform9.com/support/kubernetes-at-the-command-line-up-and-running-with-kubectl/)
        - [IBM Cloud Container Service](https://console.ng.bluemix.net/docs/containers/container_index.html).

- - **Turnkey Cloud Solutions**For Kubernetes, we have some Turnkey Cloud Solutions, with which Kubernetes can be installed with just a few commands on an underlying IaaS platform, such as:

- - - - - [Google Compute Engine](https://kubernetes.io/docs/getting-started-guides/gce/)
        - [Amazon AWS](https://kubernetes.io/docs/getting-started-guides/aws/)
        - [Microsoft Azure](https://kubernetes.io/docs/getting-started-guides/azure/)
        - [Tectonic by CoreOS](https://coreos.com/tectonic).

- - **Bare Metal**Kubernetes can be installed on bare metal provided by different cloud providers.

##### 4.3.7 Kubernetes Installation Tools/Resources

- - - **kubeadm**
      [kubeadm](https://github.com/kubernetes/kubeadm) is a first-class citizen on the Kubernetes ecosystem. It is a secure and recommended way to bootstrap the Kubernetes cluster. It has a set of building blocks to setup the cluster, but it is easily extendable to add more functionality. Please note that kubeadm does not support the provisioning of machines.
    - **KubeSpray**
      With [KubeSpray](https://github.com/kubernetes-incubator/kubespray) (formerly known as Kargo), we can install Highly Available Kubernetes clusters on AWS, GCE, Azure, OpenStack, or bare metal. KubeSpray is based on Ansible, and is available on most Linux distributions. It is a [Kubernetes Incubator](https://github.com/kubernetes-incubator/kargo) project.
    - **Kops**
      With [Kops](https://github.com/kubernetes/kops), we can create, destroy, upgrade, and maintain production-grade, highly-available Kubernetes clusters from the command line. It can provision the machines as well. Currently, AWS is officially supported. Support for GCE and VMware vSphere are in alpha stage, and other platforms are planned for the future.

If the existing solutions and tools do not fit your requirements, then [you can always install Kubernetes from scratch](https://kubernetes.io/docs/getting-started-guides/scratch/).

It is worth checking out the *Kubernetes The Hard Way* GitHub project by [Kelsey Hightower](https://twitter.com/kelseyhightower), which shares the manual steps involved in bootstrapping a Kubernetes cluster.

