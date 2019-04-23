package algorithm.队列和栈;


import java.util.ArrayList;
import java.util.List;

/**
 * 841. 钥匙和房间
 *
 * https://leetcode-cn.com/problems/keys-and-rooms/
 */
public class _841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        // 解题思路：从0号房间开始遍历，获取钥匙列表，然后对钥匙列表中的每个房间进行判断，判断是否遍历过了，如果遍历过了，说明该房间能够有钥匙打开
        // 如果没有，说明没有钥匙打开。

        boolean[] visited = new boolean[rooms.size()]; // 记录房间是否被浏览过
        visited[0] = true;
        BFS(rooms, visited, rooms.get(0));
        // 遍历visited
        for (boolean visit: visited) {
            if (!visit){
                // 一旦发现有房间没有遍历到，说明有房间无法被打开
                return false;
            }
        }
        return true;
    }

    private void BFS(List<List<Integer>> rooms, boolean[] visited, List<Integer> key){
        // 遍历每个房间，获取每个房间中的钥匙
        for (int i = 0; i < key.size(); i++){
            if (!visited[key.get(i)]){
                visited[key.get(i)] = true;
                BFS(rooms, visited, rooms.get(key.get(i)));
            }
        }
    }


    public static void main(String[] args){
        _841 p = new _841();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> key = new ArrayList<>();
        key.add(1);
        key.add(3);
        rooms.add(key);
        key = new ArrayList<>();
        key.add(3);
        key.add(0);
        key.add(1);
        rooms.add(key);
        key = new ArrayList<>();
        key.add(2);
        rooms.add(key);
        key = new ArrayList<>();
        key.add(0);
        rooms.add(key);
        System.out.println(p.canVisitAllRooms(rooms));
    }
}
