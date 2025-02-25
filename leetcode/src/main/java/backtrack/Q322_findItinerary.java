package backtrack;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xcai
 * @date 2025/02/21
 * @see <a href=''>Conf<a/>
 *
 * @示例 1：
 * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * 输出：["JFK","MUC","LHR","SFO","SJC"]
 *
 * @示例 2：
 * 输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 *
 * @params tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点
 */
public class Q322_findItinerary {
    private LinkedList<String> res;
    private LinkedList<String> path = new LinkedList<>();
    boolean[] used;

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort(Comparator.comparing(List::getFirst));
        path.add("JFK");
        used = new boolean[tickets.size()];
        backtrack(tickets);
        return res;
    }

    private boolean backtrack(List<List<String>> tickets) {
        if (path.size() == tickets.size() + 1) { //因为以JFK为起点
            res = new LinkedList<>(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (used[i]) continue;
            if (!tickets.get(i).get(0).equals(path.getLast())) continue;
            path.add(tickets.get(i).get(1));
            used[i] = true;
            if (backtrack(tickets)) return true;
            used[i] = false;
            path.removeLast();
        }
        return false;
    }

}
