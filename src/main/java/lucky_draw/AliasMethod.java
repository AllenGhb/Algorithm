package lucky_draw;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public final class AliasMethod {

    private final Random random;

    private final int[] alias;
    private final double[] prob;

    public AliasMethod(List<Double> probabilities){
        this(probabilities,new Random());
    }

    public AliasMethod(List<Double> probabilities,Random random){
        /* Begin by doing basic structural checks on the inputs. */
        if (probabilities == null || random == null)
            throw new NullPointerException();
        if (probabilities.size() == 0)
            throw new IllegalArgumentException("Probability vector must be nonempty.");

        /* Allocate space for the probability and alias tables. */
        prob = new double[probabilities.size()];
        alias = new int[probabilities.size()];

        /* Store the underlying generator. */
        this.random = random;

        /* Compute the average probability and cache it for later use. */
        final double average = 1.0;

        /* Make a copy of the probabilities list, since we will be making
         * changes to it.
         */
        probabilities = new ArrayList<Double>(probabilities);

        /* Create two stacks to act as worklists as we populate the tables. */
        Deque<Integer> small = new ArrayDeque<Integer>();
        Deque<Integer> large = new ArrayDeque<Integer>();

        /* Populate the stacks with the input probabilities. */
        for (int i = 0; i < probabilities.size(); ++i) {
            /* If the probability is below the average probability, then we add
             * it to the small list; otherwise we add it to the large list.
             */
            probabilities.set(i,probabilities.get(i) * probabilities.size());
            if (probabilities.get(i) >= average)
                large.add(i);
            else
                small.add(i);
        }

        /* As a note: in the mathematical specification of the algorithm, we
         * will always exhaust the small list before the big list.  However,
         * due to floating point inaccuracies, this is not necessarily true.
         * Consequently, this inner loop (which tries to pair small and large
         * elements) will have to check that both lists aren't empty.
         */
        while (!small.isEmpty() && !large.isEmpty()) {
            /* Get the index of the small and the large probabilities. */
            int less = small.removeLast();
            int more = large.removeLast();

            /* These probabilities have not yet been scaled up to be such that
             * 1/n is given weight 1.0.  We do this here instead.
             */
            prob[less] = probabilities.get(less);
            alias[less] = more;

            /* Decrease the probability of the larger one by the appropriate
             * amount.
             */
            probabilities.set(more,
                    (probabilities.get(more) + probabilities.get(less)) - average);

            /* If the new probability is less than the average, add it into the
             * small list; otherwise add it to the large list.
             */
            if (probabilities.get(more) >= average)
                large.add(more);
            else
                small.add(more);
        }

        /* At this point, everything is in one list, which means that the
         * remaining probabilities should all be 1/n.  Based on this, set them
         * appropriately.  Due to numerical issues, we can't be sure which
         * stack will hold the entries, so we empty both.
         */
        while (!small.isEmpty())
            prob[small.removeLast()] = 1.0;
        while (!large.isEmpty())
            prob[large.removeLast()] = 1.0;
    }

    private int next() {
        // 随机产生1~length 之间的整数i,决定落在哪一列。
        int column = random.nextInt(prob.length);
        // 随机选择0~1之间的任意数，判断其与Prab[i]大小，如果小于Prab[i]，
        // 则采样i，如果大于Prab[i]，则采样Alias[i]
        boolean coinToss = random.nextDouble() < prob[column];
        return coinToss ? column : alias[column];
    }

    public static void main(String[] args) {
        TreeMap<String,Double> map = new TreeMap<String, Double>();
        map.put("1金币", 1/8D);
        map.put("2金币", 1/5D);
        map.put("3金币", 1/10D);
        map.put("4金币", 1/4D);
        map.put("5金币", 1/10D);
        map.put("6金币", 1/10D);
        map.put("未中奖", 1/8D);
        /*map.put("1金币", 0.2);
        map.put("2金币", 0.15);
        map.put("3金币", 0.1);
        map.put("4金币", 0.05);
        map.put("未中奖", 0.5);*/

        List<Double> list = new ArrayList<Double>(map.values());
        List<String> gifts = new ArrayList<String>(map.keySet());

        AliasMethod method = new AliasMethod(list);

        Map<String,AtomicInteger> resultMap = new HashMap<String, AtomicInteger>();

        for(int i = 0; i < 1; i++){
            int index = method.next();
            String key = gifts.get(index);
            if(!resultMap.containsKey(key)){
                resultMap.put(key,new AtomicInteger());
            }
            resultMap.get(key).incrementAndGet();
        }
        for(String key : resultMap.keySet()){
            System.out.println(key + "==" + resultMap.get(key));
        }
    }
}
