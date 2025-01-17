package examples.si;

import examples.si.benchmarks.cec2005.ShiftedSphereFunction;
import examples.si.benchmarks.cec2018.MIDTLZ1;
import examples.si.benchmarks.nonGeneral.classical.multimodal.nonseparable.ZakharovFunction;
import examples.si.benchmarks.nonGeneral.classical.multimodal.separable.*;
import examples.si.benchmarks.nonGeneral.classical.unimodal.nonseparable.BentCigarFunction;
import examples.si.benchmarks.nonGeneral.classical.unimodal.nonseparable.Trid;
import examples.si.benchmarks.nonGeneral.classical.unimodal.nonseparable.DixonPriceFunction;
import examples.si.benchmarks.nonGeneral.classical.unimodal.separable.QuarticFunction;
import examples.si.benchmarks.singleObjective.*;
import examples.si.benchmarks.singleObjective.Bukin4Function;
import examples.si.benchmarks.singleObjective.EasomFunction;
import examples.si.benchmarks.singleObjective.SphereFunction;
import org.usa.soc.si.SIAlgorithm;
import org.usa.soc.si.ObjectiveFunction;
import examples.si.algo.abc.ABC;
import examples.si.algo.aco.ACO;
import examples.si.algo.ba.BA;
import examples.si.algo.choa.CHOA;
import examples.si.algo.choa.Chaotics;
import examples.si.algo.cs.CS;
import examples.si.algo.fa.FA;
import examples.si.algo.geo.GEO;
import examples.si.algo.gwo.GWO;
import examples.si.algo.jso.JSO;
import examples.si.algo.mbo.MBO;
import examples.si.algo.ms.MS;
import examples.si.algo.pso.PSO;
import examples.si.algo.alo.ALO;
import examples.si.algo.also.ALSO;
import examples.si.algo.avoa.AVOA;
import examples.si.algo.cso.CSO;
import examples.si.algo.goa.GOA;
import examples.si.algo.gso.GSO;
import examples.si.algo.mfa.MFA;
import examples.si.algo.ssa.SSA;
import examples.si.algo.tsa.TSA;
import examples.si.algo.tsoa.TSOA;
import examples.si.algo.tco.TCO;
import examples.si.algo.zoa.ZOA;
import org.usa.soc.util.Randoms;
import examples.si.algo.wso.WSO;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmFactory {

    private int a;
    private ObjectiveFunction fn;

    public AlgorithmFactory(int algorithmIndex, ObjectiveFunction fn) {
        this.a = algorithmIndex;
        this.fn = fn;
    }


    public SIAlgorithm getAlgorithm(int steps, int agents) {
        switch (a){
            case 0 : return new PSO(
                    fn,
                    agents,
                    fn.getNumberOfDimensions(),
                    steps,
                    1.496180,
                    1.496180,
                    0.729844,
                    fn.getMin(),
                    fn.getMax(),
                    true);
            case 1: return new ACO(
                    fn,
                    agents,
                    steps,
                    5,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true
            );
            case 2: return new CSO(
                    fn,
                    fn.getNumberOfDimensions(),
                    steps,
                    agents,
                    0.1,
                    fn.getMin(),
                    fn.getMax(),
                    3,
                    0.85,
                    0.2,
                    true,
                    2.05,
                    0.2,
                    true
            );
            case 3: {
                return new GSO(
                        fn,
                        fn.getNumberOfDimensions(),
                        steps,
                        agents,
                        fn.getMin(),
                        fn.getMax(),
                        5,
                        1,
                        0.4,
                        0.6,
                        2,
                        1,
                        0.08,
                        0.03,
                        true
                );
            }
            case 4: return new MBO(
                    fn,
                    agents,
                    100,
                    30,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    0.9,
                    0,
                    10,
                    0.5,
                    0.5,
                    10
            );
            case 5: return new MS(
                    fn,
                    steps,
                    agents,
                    fn.getNumberOfDimensions(),
                    50,
                    fn.getMin(),
                    fn.getMax(),
                    0.5,
                    true
            );
            case 6: return new WSO(
                    fn,
                    steps,
                    agents,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    0.4,
                    0.4,
                    true
            );
            case 7: return new CS(
                    fn,
                    steps,
                    fn.getNumberOfDimensions(),
                    agents,
                    fn.getMin(),
                    fn.getMax(),
                    1,
                    0.75,
                    true
            );
            case 8: return new FA(
                    fn,
                    steps,
                    fn.getNumberOfDimensions(),
                    agents,
                    fn.getMin(),
                    fn.getMax(),
                    1,
                    0.2,
                    1,
                    true
            );
            case 9: return new ABC(
                    fn,
                    steps,
                    fn.getNumberOfDimensions(),
                    agents,
                    fn.getMin(),
                    fn.getMax(),
                    100,
                    true
            );
            case 10:  return new BA(
                    fn,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    agents,
                    0,
                    100,
                    0.9,
                    0.9,
                    100,
                    Randoms.rand(0.1,1),
                    true
            );
            case 11: return new TCO(
                    fn,
                    steps,
                    fn.getNumberOfDimensions(),
                    agents,
                    fn.getMin(),
                    fn.getMax(),
                    1,
                    0.8,
                    0.72,
                    1.49,
                    true
            );
            case 12: return new GWO(
                    fn,
                    steps,
                    fn.getNumberOfDimensions(),
                    agents,
                    fn.getMin(),
                    fn.getMax(),
                    true
            );
            case 13: return new MFA(
                    fn,
                    steps,
                    fn.getNumberOfDimensions(),
                    agents,
                    fn.getMin(),
                    fn.getMax(),
                    1.0
            );
            case 14: return new ALO(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true
            );
            case 15: return new ALSO(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    10,
                    210,
                    2.5,
                    0.1,
                    1.0,
                    1.0
            );
            case 16: return new GEO(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    2,
                    0.5,
                    0.5,
                    1
            );
            case 17: return new AVOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    2.5,
                    0.8,
                    0.2,
                    0.6,
                    0.4,
                    0.6
            );
            case 18: return new TSA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true
            );
            case 19: return new SSA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    0.1,
                    1.9,
                    1.204,
                    5.25,
                    0.1,
                    8.0
            );
            case 20: return new ZOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true
            );
            case 21:  return new JSO(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    3,
                    0.1
            );
            case 22: return new CHOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    2.5,
                    Chaotics.type.QUADRATIC
            );
            case 23: return new CHOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    2.5,
                    Chaotics.type.BERNOULLI
            );
            case 24: return new CHOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    2.5,
                    Chaotics.type.GAUSS_MOUSE
            );
            case 25: return new CHOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    2.5,
                    Chaotics.type.LOGISTIC
            );
            case 26: return new CHOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    2.5,
                    Chaotics.type.SINGER
            );
            case 27: return new CHOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    2.5,
                    Chaotics.type.TENT
            );
            case 28: return new GOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    0.00004,
                    1.0,
                    0.5,
                    1.5
            );
            case 29: return new TSOA(
                    fn,
                    agents,
                    steps,
                    fn.getNumberOfDimensions(),
                    fn.getMin(),
                    fn.getMax(),
                    true,
                    10,
                    0.3,
                    1,
                    1.49,
                    1.5
            );
        }
        return null;
    }

    public static List<String> generateAlgo() {
        List<String> algo = new ArrayList<>();

        algo.add("PSO - Birds & Fishes");
        algo.add("ACO - Ants as a Colony");
        algo.add("CSO - Cats & Rats");
        algo.add("GSO - Glow Worm Collaboration");
        algo.add("MBO - Bees Marriage Process");
        algo.add("MS - Monkey Search Tree Branches");
        algo.add("WSO - Wasps as a Swarm");
        algo.add("CS - Cuckoo Bird Search for a Nest");
        algo.add("FA - Fireflies Swarm");
        algo.add("ABC - Bees as a Colony");
        algo.add("BA - Bats Navigation");
        algo.add("TCO - Termites Hunting");
        algo.add("GWO Gray Wolf Hunting");
        algo.add("MFA - Moths Find Flames");
        algo.add("ALO - Ant Lion Hunting");
        algo.add("ALSO - Lizards");
        algo.add("GEO - Golden Eagle");
        algo.add("AVOA - African Vulture");
        algo.add("TSA - Tunicate Swarm ");
        algo.add("SSA - Squirrels");
        algo.add("ZOA - Zebras");
        algo.add("JSO - Jellifish");
        algo.add("CHOA_QUADRATIC - Chimps");
        algo.add("CHOA_BERNOULLI - Chimps");
        algo.add("CHOA_GAUSS_MOUSE - Chimps");
        algo.add("CHOA_LOGISTIC - Chimps");
        algo.add("CHOA_SINGER - Chimps");
        algo.add("CHOA_TENT - Chimps");
        algo.add("GOA - Grass Hopper");
        algo.add("TSOA - Tree Search Optimization Algorithm");
        
        return algo;
    }

    public static class FunctionsList {
        public static ObjectiveFunction[] getFunctionList(int n){
            return new ObjectiveFunction[]{
                    new examples.si.benchmarks.nonGeneral.classical.multimodal.nonseparable.AckleysFunction().updateDimensions(n),
                    new BealeFunction().updateDimensions(n),
                    new BoothsFunction().updateDimensions(n),
                    new Bukin4Function().updateDimensions(n),
                    new CrossInTrayFunction().updateDimensions(n),
                    new EasomFunction().updateDimensions(n),
                    new EggholderFunction().updateDimensions(n),
                    new GoldsteinPrice().updateDimensions(n),
                    new HimmelblausFunction().updateDimensions(n),
                    new HolderTableFunction().updateDimensions(n),
                    new LevyFunction().updateDimensions(n),
                    new MatyasFunction().updateDimensions(n),
                    new McCormickFunction().updateDimensions(n),
                    new RastriginFunction().updateDimensions(n),
                    new RosenbrockFunction().updateDimensions(n),
                    new SchafferFunctionN4().updateDimensions(n),
                    new SchafferFunction().updateDimensions(n),
                    new SphereFunction().updateDimensions(n),
                    new StyblinskiTangFunction().updateDimensions(n),
                    new ThreeHumpCamelFunction().updateDimensions(n),
                    new ChungReynoldsSquares().updateDimensions(n),
                    new SumSquares().updateDimensions(n),
                    new DixonPriceFunction().updateDimensions(n),
                    new Debfunction().updateDimensions(n),
                    new ZakharovFunction().updateDimensions(n),
                    new CsendesFunction().updateDimensions(n),
                    new QuarticFunction().updateDimensions(n),
                    new Michalewicz10().setFixedDimentions(10),
                    new Michalewicz5().setFixedDimentions(5),
                    new Trid().updateDimensions(n),
                    new Alpine1Function().updateDimensions(n),
                    new RastriginFunction().updateDimensions(n),
                    new examples.si.benchmarks.nonGeneral.classical.multimodal.nonseparable.StyblinskiTangFunction().updateDimensions(n),
                    new BentCigarFunction().updateDimensions(n),
                    new ShiftedSphereFunction().updateDimensions(n),
                    new MIDTLZ1(10, 10).setFixedDimentions(n)
            };
        }
    }
}
