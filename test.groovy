#!/usr/bin/env groovy

// def names = ['mani','3mmi-m','3mmi-me','3mmi-m3','73mmi-m','73mmi-mer','73mmi-tygm'].unique()


def validateCommits(Integer range = 5 ,def regex = /.*:.*/){
        
        List commits = "git --no-pager log --pretty=format:'%an:%s'".execute().text.tokenize("\n").unique()
        (matches,nonMatches) = commits.split{ it =~ regex }

        String moreThanRange = "Plus ${ matches.size() - range } others..."
        String lessThanRange = "No further commits found."

        matches = (matches.size() < range) ? (matches.size() == 0) ? matches : matches << lessThanRange : matches[0..range - 1] << moreThanRange
    

    return matches
} 

def regex = '.*:'
def matches = validateCommits(-6, regex = regex)
def test = (matches.size() == 0) ? "No matches found" : matches 
println test

