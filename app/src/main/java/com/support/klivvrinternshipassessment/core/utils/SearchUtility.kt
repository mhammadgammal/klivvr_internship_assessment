package com.support.klivvrinternshipassessment.core.utils

import com.support.klivvrinternshipassessment.core.data.CityModel

class TreeNode(val city: CityModel) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinarySearchTree {
    private var root: TreeNode? = null

    fun insert(city: CityModel) {
        root = insertRec(root, city)
    }

    private fun insertRec(root: TreeNode?, city: CityModel): TreeNode {
        if (root == null) {
            return TreeNode(city)
        }
        if (city.name < root.city.name) {
            root.left = insertRec(root.left, city)
        } else if (city.name > root.city.name) {
            root.right = insertRec(root.right, city)
        }
        return root
    }

    fun search(query: String): List<CityModel> {
        val result = mutableListOf<CityModel>()
        searchRec(root, query, result)
        return mergeSort(result)
    }

    private fun searchRec(root: TreeNode?, query: String, result: MutableList<CityModel>) {
        if (root == null) {
            return
        }
        if (root.city.name.startsWith(query, ignoreCase = true)) {
            result.add(root.city)
        }
        searchRec(root.left, query, result)
        searchRec(root.right, query, result)
    }
}
