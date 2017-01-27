package com.javarush.test.level20.lesson10.bonus04;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    public static void main(String[] args) {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
    }

    private Node leftNode = null;
    private Node rightNode = null;
    private int maxLevel = 0;
    private int size = 0;

    @Override
    public boolean add(String s)
    {
        if (maxLevel == 0 && leftNode == null)
            leftNode = new Node();

        return true;
    }

    @Override
    public boolean remove(Object o)
    {
        return super.remove(o);
    }

    public String getParent(String value) {
        //have to be implemented
        return getNode(value).getParent().getName();
    }

    @Override
    public int size()
    {
        return size;
    }

    private Node getNode (String name)
    {
        Node result = null;

        if (leftNode != null)
            result = getNodeByName(leftNode, name);
        if (result == null && rightNode != null)
            result = getNodeByName(rightNode, name);

        return result;
    }

    private Node getNodeByName(Node node, String name)
    {
        Node result = null;

        if (name.equals(node.getName()))
            result = node;

        if (result == null && node.getLeftNode() != null)
            result = getNodeByName(node.getLeftNode(), name);

        if (result == null && node.getRightNode() != null)
            result = getNodeByName(node.getRightNode(), name);

        return result;
    }

    @Override
    public String remove(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }
}

class Node
{
    private Node leftNode = null;
    private Node rightNode = null;
    private Node parent;
    private String name;
    private int level;

    public Node(Node parent, String name, int level)
    {
        this.parent = parent;
        this.name = name;
        this.level = level;
    }

    public void setLeftNode(Node leftNode)
    {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode)
    {
        this.rightNode = rightNode;
    }

    public int getLevel()
    {
        return level;
    }

    public String getName()
    {
        return name;
    }

    public Node getParent()
    {
        return parent;
    }

    public Node getLeftNode()
    {
        return leftNode;
    }

    public Node getRightNode()
    {
        return rightNode;
    }
}