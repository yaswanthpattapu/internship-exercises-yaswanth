# Branch Predictors
## Evaluate SPEC programs in different branch predictors 
### Using Champsim and download dependencies 
Install [Champsim](https://github.com/ChampSim/ChampSim) after cloning the repository download the vcpkg dependencies with
```
git submodule update --init
vcpkg/bootstrap-vcpkg.sh
vcpkg/vcpkg install
```
### Compile 
ChampSim takes a JSON configuration script. Examine `champsim_config.json` for a fully-specified example. All options described in this file are optional and will be replaced with defaults if not specified. The configuration scrip can also be run without input
We can change ooo_cpu.branch_predictor to the name of the predictor which is available in the `/Champsim/branch/` folder before compiling.
```
$ ./config.sh champsim_config.json
$ make
```
### Run simulation
Execute the binary directly.
```
$ bin/champsim --warmup_instructions 200000000 --simulation_instructions 500000000 ~/path/to/traces/619.lbm_s-2677B.champsimtrace.xz
```
We executed every SPEC program given to us by 500 Million instructions in the detailed mode after
a warmup of 200 Million instructions.
We will run the simulation for 3 SPEC programs given to us with 3 different branch predictors. 

## Exploring different set of history lengths for the TAGE predictor
We have different set of history lengths for the TAGE predictor implementation in `/Champsim/branch/tage` folder. While running 
simulation for different version include different files related to a particular version of TAGE predictor tage.h / tage_2.h / tage_3.h
in tage.cc and run the simulation using the command mentioned above.

## Exploring variations of Hybrid predictors using perceptron and TAGE
We have different hybrid perceptron and TAGE predictors. The relative storage allocated to the individual predictors
varied as 50:50 - Hybrid1, 70-30 - Hybrid2, 30-70 - Hybrid3. Proportion for perceptron and TAGE respectively.
We have to choose by using which predictor we have to run the simulation in `champsim_config.json`. and run the simulation using the command mentioned above.




