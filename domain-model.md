Core:
User Stories:
As a user, I want to know which of two hands are the winning hand so that I can know who has the best hand

| Class | Attribute      | Method                          | Scenario | Output               |
|-------|----------------|---------------------------------|----------|----------------------|
| Poker | String[] hand1 | winningPair(String[], String[]) |          | String[] winningHand |
|       | String[] hand2 |                                 |          |                      |

Extension:

| Class | Attribute                         | Method        | Scenario | Output           |
|-------|-----------------------------------|---------------|----------|------------------|
| Poker | List<Hand> hands                  | winningHand() |          | Hand winningHand |
|       |                                   |               |          |                  |
| Hand  | List<String> cards                | calcPoints()  |          | points           | 
|       | Map<String, Integer> cardPointMap | countPoints() |          |                  |
|       | Map<String, Integer> cardPointMap |               |          |                  |
|       | int points                        |               |          |                  |

