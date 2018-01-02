package com.loska;

import java.util.LinkedList;

public class MyLinkedList implements NodeList{
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null) {
            // This list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0 ) {
                //newItem is greater, move right if possible
                if (currentItem.next() !=null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0){
                //newItem is less, insert before
                if (currentItem.previous() != null){
                    currentItem.setPrevious(newItem);
                    newItem.setNext(currentItem);
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                } else {
                    //node with no previous is the root
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;

            } else {
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }


        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item !=null){
            System.out.println( "Delete item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem !=null){
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                if(currentItem == this.root){
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;

            } else if (comparison <0){
                currentItem = currentItem.next();
            } else {
                System.out.println(item +  " does not exist.");
                return false;
            }

        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null){
            System.out.println("This list is empty");
        }

        while (root != null){
            System.out.println(root.getValue());
            root = root.next();
        }


    }
}
