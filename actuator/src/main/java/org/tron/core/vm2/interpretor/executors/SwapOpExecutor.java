package org.tron.core.vm2.interpretor.executors;

import org.tron.core.vm.program.Stack;
import org.tron.core.vm2.ContractContext;
import org.tron.core.vm2.interpretor.Op;
import org.tron.core.vm2.interpretor.Op.Tier;

public class SwapOpExecutor implements OpExecutor {

  private static SwapOpExecutor INSTANCE = new SwapOpExecutor();

  private SwapOpExecutor() {
  }

  public static SwapOpExecutor getInstance() {
    return INSTANCE;
  }


  @Override
  public void exec(Op op, ContractContext context) {
    context.spendEnergy(Tier.VeryLowTier.asInt(), op.name());

    Stack stack = context.getStack();
    int n = op.val() - Op.SWAP1.val() + 2;
    stack.swap(stack.size() - 1, stack.size() - n);
    context.step();
  }
}