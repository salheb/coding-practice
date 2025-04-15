package net.julionogueira.ztm.sectionthree

class Node(){
    val leftChild: Node?
    val rightChild: Node?
    val parent: Node?
    val value: Int
    constructor(val value: Int, val leftNode: Node, val rightNode: Node, val parent: Node){
        this.leftChild = leftChild,
        this.rightChild = rightChild,
        this.value = value
        this.parent = parent
    }

    public fun getLeftChild(){
        return this.leftChild
    }

    public fun getRighthild(){
        return this.leftChild
    }
}

public class BinaryTree(){
    val mainValue: Node?

    constructor(val mainValue: Node){
        this.mainValue = mainValue
    }

    public fun getRootNode(): Node?{
        return mainValue
    }

    public fun inserNode(){}

    public fun deleteNode()

    public fun searchNode(val searchFor: Node)

    public fun sortTree()
}