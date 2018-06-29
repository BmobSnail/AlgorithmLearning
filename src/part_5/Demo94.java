package part_5;

/**
 * 字符串问题
 * 字典树(前缀树)的实现
 *
 * 题目：
 * 字典树又称为前缀树或Trie树，是处理字符串常见的数据结构。假设组成所有单词的字符
 * 仅是 'a'~'z' 请实现字典树结构，并包含一下四个主要功能。
 * 1.void insert(String word):添加 word,可重复添加
 * 2.void delete(String word):删除 word,如果 word 添加过多次，仅删除一个
 * 3.boolean search(String word):查询 word 是否在字典树中
 * 4.int prefixNumber(String pre):返回以字符串 pre 为前缀的单词数量
 * */
public class Demo94 {

    public class TrieNode{
        public int path;
        public int end;
        public TrieNode[] map;

        public TrieNode(){
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }
    }

    private TrieNode root;

    {
        root = new TrieNode();
    }

    public void inSert(String word) {
        if (word == null)
            return;
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null)
                node.map[index] = new TrieNode();
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word)) {
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index].path-- == 1) {
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            node.end--;
        }
    }

    public boolean search(String word) {
        if (word == null)
            return false;
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null)
                return false;
            node = node.map[index];
        }
        return node.end != 0;
    }

    public int prefixNumber(String pre) {
        if (pre == null)
            return 0;
        char[] chs = pre.toCharArray();
        TrieNode node = root;
        int index= 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null)
                return 0;
            node = node.map[index];
        }
        return node.path;
    }
}
