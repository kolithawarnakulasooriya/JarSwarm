package org.usa.soc.benchmarks;

import org.usa.soc.core.ObjectiveFunction;
import org.usa.soc.benchmarks.DynamicCompositeBenchmarkFunctions.Function16;
import org.usa.soc.benchmarks.DynamicCompositeBenchmarkFunctions.Function17;
import org.usa.soc.benchmarks.DynamicCompositeBenchmarkFunctions.Function18;
import org.usa.soc.benchmarks.DynamicCompositeBenchmarkFunctions.Function20;
import org.usa.soc.benchmarks.singleObjective.*;

public class FunctionsList {
    public ObjectiveFunction[] getFunctionList(){
        return new ObjectiveFunction[]{
                new AckleysFunction(),
                new BealeFunction(),
                new BoothsFunction(),
                new Bukin4Function(),
                new CrossInTrayFunction(),
                new EasomFunction(),
                new EggholderFunction(),
                new GoldsteinPrice(),
                new HimmelblausFunction(),
                new HolderTableFunction(),
                new LevyFunction(),
                new MatyasFunction(),
                new McCormickFunction(),
                new RastriginFunction(),
                new RosenbrockFunction(),
                new SchafferFunctionN4(),
                new SchafferFunction(),
                new SphereFunction(),
                new StyblinskiTangFunction(),
                new ThreeHumpCamelFunction(),
                new ChungReynoldsSquares(),
                new SumSquares(),
                new Function16(2),
                new Function17(2),
                new Function18(2),
                new Function20(2)
        };
    }
}
