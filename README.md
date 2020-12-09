# concurrency
Implementation of a model where an actor (Martin) and n Enemies compete for a shared resource (the road).

The finite state machines are modelled with [LTSA](https://www.doc.ic.ac.uk/ltsa/).

In this model, the road is a resource shared by zero to n enemies and zero to one Martin. Martin and the enemies must not be on the road at the same time. Martin has a sensor in front of his house that lets him know when there is an enemy on the road.

## Output
Execution of the implementation can be accomplished with
`java -cp ../ martin.MainMartin > output.txt` ​(for example).
The output may look like this:
```
The gate is lowered.
Enemy 1 is on the road.
The warning indicator is on.
Martin left his house and is waiting.
Martin is not on the road.
===========================================
The gate is lowered.
No enemies are on the road.
The warning indicator is off.
Martin left his house and is waiting.
Martin is not on the road.
===========================================
The gate is lowered.
No enemies are on the road.
The warning indicator is off.
Martin is on the road.
===========================================
The gate is raised.
No enemies are on the road.
The warning indicator is off.
Martin is not on the road.
```
Running the application for a few seconds and analysing the the output, it can be seen that Martin and all enemy threads eventually enter the road. Sometimes several enemies are on the road at the same time, but never together with Martin.