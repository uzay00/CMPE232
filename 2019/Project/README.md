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




 
 

 # Project

Project: Basics of Computatation Graphs
 - [Understand TensorFlow by mimicking its API from scratch](https://medium.com/@d3lm/understand-tensorflow-by-mimicking-its-api-from-scratch-faa55787170d)

 - [Deep Learning From Scratch I: Computational Graphs](http://www.deepideas.net/deep-learning-from-scratch-i-computational-graphs/)
 
 
 ### 1. Convert equation to computation graph
 first identify nodes.
 ## J = d (a + bc)##
 Here $a=5$, $b=3$,$c=2$,$d=3$,
  
 ### 1. Create Nodes
 Each node has 
  - list of input nodes
  - list of output nodes
  
 Different type of nodes
  - Placeholder
  - Variable
  - Operation
   - add, multiply, matmul, sigmoid
 
 ### 2. Build Graph
 Connect all nodes.
 
 ### 3. Execute Graph: forward propagation
  - Get topological order (on reversed graph)
  - Run forward propagation
  
 ### 4. Execute Graph: backward propagation
 compute
 $$\frac{\partial J}{\partial a}$$
 
 ![1-GraphProcessing.JPG](1-GraphProcessing.JPG)
 ![2-TopologicalOrder.JPG](2-TopologicalOrder.JPG)
 ![3-ProjectComputationGraph.JPG](3-ProjectComputationGraph.JPG)
 
 # Bonus HW
 ![0-Bonus_Arbitrage.JPG](0-Bonus_Arbitrage.JPG)
