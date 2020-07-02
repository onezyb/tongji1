package com.zyb.tjpkg.util.demo;

import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

/**
 * Created by Yambo Zhang on 2020-05-06.
 */
public class BinaryTree implements Tree {
    @Override
    public Kind getKind() {
        return null;
    }

    @Override
    public <R, D> R accept(TreeVisitor<R, D> treeVisitor, D d) {
        return null;
    }
}
