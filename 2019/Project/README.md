# Project: Basics of Computatation Graphs
Some references
 - [Understand TensorFlow by mimicking its API from scratch](https://medium.com/@d3lm/understand-tensorflow-by-mimicking-its-api-from-scratch-faa55787170d)

 - [Deep Learning From Scratch I: Computational Graphs](http://www.deepideas.net/deep-learning-from-scratch-i-computational-graphs/)
 
# Project Groups
Indicate your project groups on [google document link](https://docs.google.com/spreadsheets/d/1eA8juAoMCszqZNhIjR1ZPLR2L6qhRe1TfTPpugRA574/edit?usp=sharing)


# To-Do
Evaluation will be done over 110 Points. Extra 10 P will be given for backward propagation.

### 0. [25P] Convert equation to computation graph
First identify nodes from the given equation: Ex: `J = d (a + bc)`
  
### 1. [20P] Create Nodes
Each node has 
 - list of input nodes
 - list of output nodes
  
Different type of nodes
 - Placeholder
 - Variable
 - Operation
  - add, multiply, matmul, sigmoid
 
### 2. [10P] Build Graph
Connect all nodes.

### 3. [25P] Execute Graph: forward propagation
 - Get topological order (on reversed graph)
 - Run forward propagation with given values Ex: `a=5, b=3, c=2 ,d=3`

### 4. [30P] Execute Graph: backward propagation
 - compute `dJ/da` and other derivatives using chain rule over the edge weights on the shortest path given by the BFS(J) on the reversed graph.
 
![1-GraphProcessing.JPG](1-GraphProcessing.JPG)
![2-TopologicalOrder.JPG](2-TopologicalOrder.JPG)
![3-ProjectComputationGraph.JPG](3-ProjectComputationGraph.JPG)

# Bonus HW
![0-Bonus_Arbitrage.JPG](0-Bonus_Arbitrage.JPG)

# Project Groups
Indicate your project groups on [google document link](https://docs.google.com/spreadsheets/d/1eA8juAoMCszqZNhIjR1ZPLR2L6qhRe1TfTPpugRA574/edit?usp=sharing)


# Time

|  Date |  Program | 
|---|---|
|  9 April |   String Sorts|
|  16 April|   Tries|
|  23 April |  Holiday |
|  30 April|   Substring Search|
|  7 May|  [Project Presentation](https://github.com/uzay00/CMPE232/tree/master/2019/Project)|
|  14 May|  Review |




 
