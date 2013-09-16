import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solves UVa problem 540 "Team Queue".
 * 
 * @author samus250
 */
public class P540 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int scenarioNumber = 1;
    int numberOfTeams = Integer.parseInt(reader.readLine());

    // Case loops. 0 terminates the input.
    while (numberOfTeams > 0) {
      // Elements and team relation will be stored here.
      HashMap<Integer, Integer> elementToTeamMap = new HashMap<Integer, Integer>();

      for (int i = 0; i < numberOfTeams; i++) {
        String teamDefinition = reader.readLine();
        String[] teamDefinitionSplit = teamDefinition.split(" ");

        // Assign teams to elements. Skip first token, since it is the number of elements.
        for (int j = 1; j < teamDefinitionSplit.length; j++) {
          elementToTeamMap.put(Integer.parseInt(teamDefinitionSplit[j]), i);
        }
      }

      // Now that we have built the element -> team map, initialize team queue.
      TeamQueue teamQueue = new TeamQueue(elementToTeamMap);

      // Follow all commands. Loop breaks at STOP.
      System.out.println("Scenario #" + scenarioNumber++);
      String command = reader.readLine();
      while (command.charAt(0) != 'S') {
        if (command.charAt(0) == 'E') {
          // charAt 0-6 = enqueue, charAt 7 = space, charAt 8-> = element.
          Integer element = Integer.parseInt(command.substring(8));
          teamQueue.enqueue(element);
        } else {
          // Dequeue is the only other possible option.
          Integer element = teamQueue.dequeue();
          if (element != null) {
            System.out.println(element);
          }
        }
        command = reader.readLine();
      }
      System.out.println(); // Extra newline between scenarios.

      numberOfTeams = Integer.parseInt(reader.readLine());
    }
  }

  /**
   * Implementation of a TeamQueue.
   * 
   * @author samus250
   */
  public static class TeamQueue {
    private HashMap<Integer, Integer> elementToTeamMap;
    private Queue<Queue<Integer>> queueOfQueues;
    private HashMap<Integer, Queue<Integer>> teamToQueueMap;

    public TeamQueue(HashMap<Integer, Integer> elementToTeamMap) {
      this.elementToTeamMap = elementToTeamMap;
      this.queueOfQueues = new LinkedList<Queue<Integer>>();
      this.teamToQueueMap = new HashMap<Integer, Queue<Integer>>();
    }

    /**
     * Enqueues an element to the TeamQueue.
     * 
     * @param element The element to enqueue.
     */
    public void enqueue(Integer element) {
      // If a queue is already created with the label, then enqueue in that queue.
      int elementTeam = elementToTeamMap.get(element);
      Queue<Integer> teamQueue = teamToQueueMap.get(elementTeam);
      if (teamQueue != null) {
        teamQueue.add(element);
      } else {
        // Create a team queue, enqueue the first element, add it to the map and enqueue to the
        // queue of queues.
        teamQueue = new LinkedList<Integer>();
        teamQueue.add(element);
        teamToQueueMap.put(elementTeam, teamQueue);
        queueOfQueues.add(teamQueue);
      }
    }

    /**
     * Dequeues an element from the team queue.
     * 
     * @return The element dequeued from the TeamQueue, or null if the TeamQueue is empty.
     */
    public Integer dequeue() {
      // Peek the queue from the queue of queues, and dequeue the element from the queue. If the
      // queue gets empty with the removal of this element, remove it from the teamToQueueMap,
      // and dequeue it from the queue of queues.
      if (queueOfQueues.isEmpty()) {
        return null;
      }

      Queue<Integer> teamQueue = queueOfQueues.peek();

      Integer element = teamQueue.poll();
      if (teamQueue.isEmpty()) {
        teamToQueueMap.remove(elementToTeamMap.get(element));
        queueOfQueues.poll();
      }

      return element;
    }
  }
}
