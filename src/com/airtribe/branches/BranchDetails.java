package com.airtribe.branches;

public class BranchDetails {
    private String branchName;
    private String branchAddress;

    public BranchDetails(String branchName, String branchAddress) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    @Override
    public String toString() {
        return "{" +
                "branchName='" + branchName + '\'' +
                ", branchAddress='" + branchAddress + '\'' +
                '}';
    }
}
